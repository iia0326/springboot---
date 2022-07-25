package com.kangyi.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kangyi.pojo.*;
import com.kangyi.service.*;
import com.kangyi.util.StringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kangyi.util.StringTest.isJsonObject;

@RestController
@RequestMapping(path = "/boke")
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class Aboke {

    @Autowired
    OrderService orderService;

    @Autowired
    GuiJiService guiJiService;

    @Autowired
    HeSuanService heSuanService;

    @Autowired
    YiMiaoService yiMiaoService;

    @Autowired
    GeLiService geLiService;



    @Autowired
    GuanzhuService guanzhuService;

    @Autowired
    JiaruService jiaruService;

    @Autowired
    CommentService commentService;

    @GetMapping
    @PostMapping
    @RequestMapping("/list")
//    @ResponseBody
    public Map<String, Object> getBokeList(
//             Map<String, Object> data
            @RequestParam(value = "pno",defaultValue = "1") Integer pno,
            @RequestParam(value = "psize",defaultValue = "10") Integer psize,
            @RequestParam(value = "type",defaultValue = "0") Integer type,
            @RequestParam(value = "typeId",defaultValue = "") Long typeId,
            @RequestParam(value = "userRemark",defaultValue = "") String userRemark,
            @RequestParam(value = "orderId",defaultValue = "") Long orderId,
            @RequestParam(value = "userId",defaultValue = "") Long userId

    ){


        Map<String,Object> map=commentService.getPageByOrderId(orderId,pno,psize);

        Jiaru jiaru=jiaruService.selectOneByTwo(orderId,userId);

        if (typeId==null||typeId<=0){
            if (userRemark!=null){
                typeId= Long.valueOf( userRemark );
            }else {
                map.put( "msg","没有typeId或userRemark" );
                return map;
            }
        }

        Byte jiaruStatus = 0;
        if (jiaru!=null) {
            jiaruStatus =jiaru.getJiaru();
        }
            map.put( "jiaru", jiaruStatus );



        Guanzhu guanzhu=guanzhuService.selectOneByTwo(orderId,userId);
        Byte guanzhuStatus = 0;
        if (guanzhu!=null){
            guanzhuStatus=guanzhu.getGuanzhu();
        }
        map.put( "guanzhu",guanzhuStatus );


        Order order = orderService.selectOneById( orderId );
        if (order==null){
            System.out.println("orderId错误，没有此order");
        }

        if (order.getUserId()!=3l){
            if (order.getUserId()== userId||jiaruStatus==2){
                map.put( "louzhu",1 );
            }else{
                map.put( "louzhu",0 );
            }
        }else {
            if (userId==1l||userId==3l||jiaruStatus==2){
                map.put( "louzhu",1 );
            }else{
                map.put( "louzhu",0 );
            }
        }



        if(type==1){

            HeSuan heSuan = heSuanService.getOneById( typeId );
            System.out.println("@#$bokelist hesuan "+heSuan);
            map.put( "hesuan",heSuan  );


        }else if (type==2){

            YiMiao yiMiao = yiMiaoService.getOneById( typeId );
            map.put( "yimiao",yiMiao );

        }else if (type==3){

            GeLi geLi = geLiService.getOneById( typeId );
            map.put( "geli",geLi );

        }else {
            if(typeId!=null){
                GuiJi guiJi=guiJiService.selectOneById(typeId);
                String handelRemark = order.getHandelRemark();
                if (!isJsonObject(handelRemark)){
                    map.put( "guiji",guiJi );
                    map.put( "type",type );
                    return map;
                }
                JSONObject json_qiege = JSONObject.parseObject(handelRemark);
                String desc = json_qiege.getString( "desc" );

                try {
                    String qiekai = StringTest.StringChangeJSON( desc );
                    guiJi.setQiekai( qiekai );
                    guiJi.setData( desc );
                    map.put( "guiji",guiJi );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
        map.put( "type",type );

        System.out.println("@#$bokelist map "+map.get( "hesuan" ));

        return map;

    }

    @GetMapping
    @PostMapping
    @RequestMapping("/addComment")
    public String addComment(
            @RequestBody  Map<String, Object> data
    ){


        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
        String commentSt = JSONObject.toJSONString( data );
        Comment comment= JSON.parseObject( commentSt, Comment.class);
        System.out.println("@#$addcomment "+comment);
        if (comment==null||"null".equals( comment )){
            return "评论失败 comment空";
        }
        comment.setLevel( (byte) 0 );
        comment.setParentRead( "0" );
        int i=commentService.insertOne(comment);
        if (i<=0){
            return "评论失败 sql失败";
        }else {
            return "评论成功";
        }
    }

    @GetMapping
    @PostMapping
    @RequestMapping("/delectComment")
    @ResponseBody
    public String delectComment(
            @RequestParam(value = "commentId",defaultValue = "10") Long commentId,
            @RequestParam(value = "userId",defaultValue = "10") Long userId
    ){

        if (commentId==null||"null".equals( commentId )){
            return "删除失败";
        }


        int i=commentService.delectOne(commentId);
        if (i<=0){
            return "删除失败";
        }else {
            return "删除成功";
        }
    }

    @GetMapping
    @PostMapping
    @RequestMapping("/upComment")
    @ResponseBody
    public String updataComment(
            @RequestParam(value = "commentId",defaultValue = "") Long commentId,
            @RequestParam(value = "level",defaultValue = "0") Integer level,
            @RequestParam(value = "userId",defaultValue = "") Long userId
    ){

        if (commentId==null||"null".equals( commentId )){
            return "失败,commentId空";
        }


        Comment comment = new Comment();
        comment.setLevel( (byte)level.intValue() );
        comment.setCommentId( commentId );
        int i=commentService.updataOneById(commentId,comment);
        if (i<=0){
            return "失败,sql";
        }else {
            return "成功";
        }
    }

    @GetMapping
    @PostMapping
    @RequestMapping("/jiaru")
    @ResponseBody
    public String jiaruBoke(
            @RequestBody  Map<String, Object> data
    ){


        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
        String st = JSONObject.toJSONString( data );
        Jiaru jiaru= JSON.parseObject( st, Jiaru.class);
        Long orderId = jiaru.getOrderId();
        Order order = orderService.selectOneById( orderId );
        if(order!=null){
            jiaru.setToUserId( order.getUserId() );
        }

        if (jiaru==null||"null".equals( jiaru )){
            return "失败";
        }
        int i=jiaruService.insertOne(jiaru);
        if (i<=0){
            return "失败";
        }else {
            return "成功";
        }
    }

    @GetMapping
    @PostMapping
    @RequestMapping("/guanzhu")
    @ResponseBody
    public String guanzhuBoke(
            @RequestBody  Map<String, Object> data



    ){


        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
        String st = JSONObject.toJSONString( data );
        Guanzhu guanzhu= JSON.parseObject( st, Guanzhu.class);
        if (guanzhu==null||"null".equals( guanzhu )){
            return "失败";
        }
        int i=guanzhuService.insertOne(guanzhu);
        if (i<=0){
            return "失败";
        }else {
            return "成功";
        }
    }

}
