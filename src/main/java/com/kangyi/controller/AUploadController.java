package com.kangyi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kangyi.pojo.*;
import com.kangyi.service.*;
import com.kangyi.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

import static com.kangyi.util.StringToDate.*;


@RestController
@RequestMapping(path = "/upload")
//@CrossOrigin(origins = "*",allowCredentials = "true")
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class AUploadController {

        @Autowired
    OrderService orderService;

        @Autowired
    GuiJiService guiJiService;

        @Autowired
    GeLiService geLiService;

        @Autowired
    HeSuanService heSuanService;

        @Autowired
        YiMiaoService yiMiaoService;

        @Autowired
        UserService userService;

    @Autowired
    GuanzhuService guanzhuService;

    @Autowired
    CommentService commentService;

     @GetMapping
    @PostMapping
    @RequestMapping(path = "/list")
    @ResponseBody
    public Map<String, Object> getList(
//            @RequestParam(value = "sortField",defaultValue = "") String sortField,
//            @RequestParam(value = "sortType",defaultValue = "") String sortType,
            @RequestBody  Map<String, Object> map,
//            @RequestParam(value = "etime",defaultValue = "null") String etime,
//            @RequestParam(value = "btime",defaultValue = "null") String btime,
            HttpSession session
            ) {

//         System.out.println("  !" +map.toString());
         String sortField="insertTime";
         String sortType="desc";


         String btime= String.valueOf( map.get( "btime" ) );
         String etime= String.valueOf( map.get( "etime" ) );
         Integer type1=(Integer)map.get( "type" );
         Integer pno1=(Integer)map.get( "pno" );
         Integer psize1=(Integer)map.get( "psize" );

         Long userId=null;
         if (map.get( "userId" )!=null){
         userId= Long.parseLong( map.get( "userId" ).toString() );
         System.out.println("$$  !! 普通userId: "+userId);
         }

         if (pno1 == null){
             pno1=1;
         }
         if (psize1==null){
             psize1=20;
         }
         if (type1==null){
             type1=0;
         }
         if ("ascend".equals( String.valueOf(map.get( "sortType" )) )){
             sortType="asc";
         }else  if("descend".equals( String.valueOf(map.get( "sortType" ) ))){
             sortType="desc";
         }

         if (map.get( "sortField" )!=null){
             sortField= String.valueOf( map.get( "sortField" ) );
         }

         Map<String, Object> listForPage = orderService.getListForPage( type1, btime, etime, pno1, psize1, userId, sortField, sortType );
//         List<Order> orders = (List<Order>)listForPage.get( "order" );
         return  listForPage;
     }


    @GetMapping
    @PostMapping
    @RequestMapping(path = "/add")
    @Transactional


    public Map<String, Object> add(
            @RequestBody Map<String,Object> data,
            HttpSession session,
            HttpServletRequest request, HttpServletResponse response

    ) {



        Map<String, Object> map = new HashMap<>(3);
        Integer type = Integer.valueOf( String.valueOf( data.get( "type" ) ) );
        Long  userId = Long.valueOf( String.valueOf( data.get( "userId" ) ) );
//        Long userId = (Long) session.getAttribute("userId");
        System.out.println("$$add  !! userId: "+userId);
        System.out.println("$$add  !! data: "+data.toString());

         if(type==1) {
             if (data.get( "jingdu" ) != null || data.get( "weidu" ) != null) {


                 JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
                 String hesuanSt = JSONObject.toJSONString( data );
                 HeSuan heSuan= JSON.parseObject( hesuanSt, HeSuan.class);
               //获取当前时间，格式为yy-mm-dd hh:mm
                 heSuan.setArea( YNDhmNewDateString() );

//                 System.out.println("  @#$11 String hesuan: "+hesuanSt);
//                 System.out.println("  @#$11 String heSuan: "+heSuan);



                 long orderId = orderService.insertOrder( userId, type );
                 long hesuanId = heSuanService.inserOne( heSuan, orderId, userId, type );
                 int i = orderService.updateTypeIdOrderById( orderId, hesuanId );
                 if (i == 1) {
                     map.put( "msg", "上传成功，待审核  " );
                 } else {
                     map.put( "msg", "上传失败" );
                 }

             } else {
                 map.put( "msg", "11上传失败" );

             }

         }else if (type==2){
             if (data.get( "jingdu"  )!=null ||data.get( "weidu"  )!=null ) {
//

                 JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
                 String st = JSONObject.toJSONString( data );
                 YiMiao yiMiao1= JSON.parseObject( st, YiMiao.class);
                 System.out.println("  @#$11 String st: "+st);
                 System.out.println("  @#$11 String 实体: "+yiMiao1);

                 //获取当前时间，格式为yy-mm-dd hh:mm
                 yiMiao1.setArea( YNDhmNewDateString() );

                 long orderId =orderService.insertOrder(userId,type);
                long yimiaoId = yiMiaoService.insertOne( yiMiao1, orderId, userId, type );
                 int i = orderService.updateTypeIdOrderById( orderId, yimiaoId );
                 if (i==1) {
                   map.put( "msg", "上传成功，待审核  " );
                 }else { map.put("msg", "上传失败");}

             } else {
             map.put( "msg", "11上传失败" );

         }


         }else if (type==3){

             if (data.get( "jingdu"  )!=null ||data.get( "weidu"  )!=null ) {

                 JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
                 String st = JSONObject.toJSONString( data );
                 GeLi geLi1= JSON.parseObject( st, GeLi.class);
                 geLi1.setArea( YNDhmNewDateString() );
                 System.out.println("  @#$11 String st: "+st);
                 System.out.println("  @#$11 String 实体: "+geLi1);


                 long orderId =orderService.insertOrder(userId,type);
                 long geliId = geLiService.insertGeLi(geLi1,orderId,userId,type);
                 int i = orderService.updateTypeIdOrderById( orderId, geliId );
                if (i==1) {
                   map.put( "msg", "上传成功，待审核  " );
                 }else { map.put("msg", "上传失败");}


             } else {
                 map.put( "msg", "11上传失败" );

             }


         }else if (type==4){

             JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
             String guijis = JSONObject.toJSONString( data.get( "guiji" ) );
             ArrayList<GuiJi> listGuiJi= (ArrayList<GuiJi>)JSON.parseArray( guijis,GuiJi.class );
             System.out.println("@#$44 listGuiJi: "+listGuiJi.toString());
             System.out.println("@#$44 String guijis: "+guijis);

             long orderId =orderService.insertOrder(userId,type);
             int i = guiJiService.insertListGuiJi( listGuiJi, orderId, userId, type);
             System.out.println("uid ;"+userId);
             if (i>=1) {
                 map.put( "msg", "上传成功，待审核" );
             }else { map.put("msg", "上传失败");}




         }
        return map;
    }




    @GetMapping
    @PostMapping
    @ResponseBody
    @RequestMapping(path = "/orderSee")
    public Map<String,Object> orderSee(
            @RequestParam(value = "orderId",defaultValue = "") Long orderId,
            @RequestParam(value = "typeId",defaultValue = "") Long typeId,
            @RequestParam(value = "type",defaultValue = "") int type


    ){

        Map<String, Object> map = new HashMap<>(3);
        Order order=orderService.selectOneById(orderId);
        if (order==null){
            System.out.println("没有此orderId");
            map.put("msg", "查看失败");
            return map;
        }




        if(type==1){
             HeSuan heSuan =heSuanService.getOneById(typeId);
            Integer status=0;
            status = order.getStatus();
            System.out.println("@#$status: "+status);
            heSuan.setStatus( status );
             heSuan.setUploadTime( order.getInsertTime() );
             heSuan.setProcessTime( order.getHandleTime() );
             heSuan.setType( type );
            heSuan.setHandelRemark(order.getHandelRemark( ) );

            map.put( "heSuan",heSuan );

         }else if (type==2){

             YiMiao yiMiao= yiMiaoService.getOneById(typeId);
             yiMiao.setType( type );
             yiMiao.setStatus( order.getStatus() );
             yiMiao.setUploadTime( order.getInsertTime() );
             yiMiao.setProcessTime( order.getHandleTime() );
            yiMiao.setHandelRemark(order.getHandelRemark( ) );

            map.put( "yiMiao",yiMiao );

         }else if (type==3){

             GeLi geLi=geLiService.getOneById(typeId);
             geLi.setType( type );
             geLi.setStatus( order.getStatus() );
             geLi.setUploadTime( order.getInsertTime() );
             geLi.setProcessTime( order.getHandleTime() );

            geLi.setHandelRemark(order.getHandelRemark( ) );
            map.put( "geli",geLi );


        }else if (type==4){
             if (orderId != null){
                 map = guiJiService.getManyByOrderId( orderId );
                 map.put("type", 4);
                 Order order1 = orderService.selectOneById( orderId );
                 map.put( "status",order1.getStatus() );
                 map.put( "uploadTime",order1.getInsertTime() );
                 map.put( "processTime",order1.getHandleTime() );
                 map.put( "handelRemark",order1.getHandelRemark( ) );



             }else {
                 map.put("msg", "查看失败");

             }

         }

    return map;

    }

    @GetMapping
    @PostMapping
    @RequestMapping(value = "/update")
    @Transactional
    public Map<String,Object> upadte(
            @RequestBody Map<String,Object> data,
            HttpSession session


    ){
        Map<String, Object> map = new HashMap<>(3);
        Integer type = Integer.valueOf( String.valueOf( data.get( "type" ) ) );
        Long orderId = Long.valueOf( String.valueOf( data.get( "orderId" ) ) );
//        Long userId = (Long) data.get( "userId" );
        Long  userId = Long.valueOf( String.valueOf( data.get( "userId" ) ) );

        if (userId==null||"null".equals( userId )) {
            userId = (Long) session.getAttribute("userId");
        }

        String typeName=null;
        Long typeId =null;

//        Long userId = (Long) session.getAttribute("userId");
        if(type==1){
           typeId = Long.valueOf( String.valueOf( data.get( "typeId" ) ) );
            JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
            String st = JSONObject.toJSONString( data );
            HeSuan heSuan= JSON.parseObject( st, HeSuan.class);
            heSuan.setArea( YNDhmNewDateString() );
            typeName="核酸点："+heSuan.getHesuanPosition();

//            后面去掉
            heSuan.setHesuanId( typeId );
            int i = heSuanService.updateOne(heSuan);
            if (i>=1) {
                map.put( "msg", "修改成功，修改订单待审核  " );
            }else { map.put("msg", "修改失败");}

        }else if (type==2){

            typeId = Long.valueOf( String.valueOf( data.get( "typeId" ) ) );
            JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
            String st = JSONObject.toJSONString( data );
            YiMiao yiMiao= JSON.parseObject( st, YiMiao.class);
            yiMiao.setArea( YNDhmNewDateString() );
            typeName="疫苗点："+yiMiao.getYimiaoPosition();


            yiMiao.setYimiaoId( typeId );
            int i = yiMiaoService.updateOne(yiMiao );
            if (i>=1) {
                map.put( "msg", "修改成功，修改订单待审核  " );
            }else { map.put("msg", "修改失败");}


        }else if (type==3){
             typeId = Long.valueOf( String.valueOf( data.get( "typeId" ) ) );
            JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
            String st = JSONObject.toJSONString( data );
            GeLi geLi= JSON.parseObject( st, GeLi.class);
            geLi.setArea( YNDhmNewDateString() );
            typeName="隔离点："+geLi.getGelidianPosition();


            geLi.setGeliId( typeId  );

            int i = geLiService.updateOne( geLi );
            if (i>=1) {
                map.put( "msg", "修改成功，修改订单待审核  " );
            }else { map.put("msg", "修改失败");}

        }else if (type==4){


            JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
            String guijis = JSONObject.toJSONString( data.get( "guiji" ) );
            ArrayList<GuiJi> listGuiJi= (ArrayList<GuiJi>)JSON.parseArray( guijis,GuiJi.class );
            typeName="确诊患者轨迹信息";




            guiJiService.delectManyByOrderId( orderId );
            int i = guiJiService.insertListGuiJi( listGuiJi, orderId, userId, type );
            typeId =  listGuiJi.get( 0 ).getGuijiId(  );


            if (i>=1) {
                map.put( "msg", "修改成功，修改订单待审核  " );
            }else {
                map.put("msg", "修改失败");
                return map;
            }

        }

        List<Comment> commentList=new ArrayList<>(  );
        List<Guanzhu> guanzhuList = guanzhuService.selectManyByStatusOrderId(  1, orderId );
        for (Guanzhu guanzhu:guanzhuList){
            Comment comment = new Comment();
            comment.setParentId( guanzhu.getUserId() );
            comment.setParentRead( "0" );
            comment.setLevel( (byte)0 );
            comment.setContent( "你关注的疫情消息 "+typeName+" 已更新" );
            comment.setOrderId( orderId );
            comment.setCreateTime( new Date(  ) );
            comment.setMessageType( (byte)0 );
            comment.setSendId( userId );
            comment.setCommentLouzhu( (byte)1 );
            comment.setType( (byte) type.intValue() );
            comment.setUserRemark( String.valueOf( typeId ) );
            commentList.add( comment );
            comment.setTypeName( typeName );
//            comment.setUserRemark( typeId );
        }
        if (commentList!=null&&commentList.size()>0){
        int ii=commentService.insertList(commentList);
        }

        Order order = new Order();
        order.setOrderId( orderId );
//        order.setStatus( 1 );

        orderService.updateAllOrderById( order );
        return map;
    }






    @GetMapping
    @PostMapping
    @ResponseBody
    @Transactional
    @RequestMapping(path = "/delect")
    public Map<String,Object> delect(
            @RequestParam(value = "orderId",defaultValue = "") Long orderId,
            @RequestParam(value = "typeId",defaultValue = "") Long typeId,
            @RequestParam(value = "type",defaultValue = "") int type
    ){

        Map<String, Object> map = new HashMap<>(3);


        if(type==1){
            int i = heSuanService.delectOneById(typeId);
            if (i>=1) {
                map.put( "msg", "删除成功" );
            }else {
                map.put("msg", "删除失败");
                System.out.println("@#$ "+i);
            }
            System.out.println("@#$ "+i);


        }else if (type==2){
            int i  = yiMiaoService.delectOneById(typeId);
            if (i>=1) {
                map.put( "msg", "删除成功" );
            }else {
                map.put("msg", "删除失败");
                System.out.println("@#$ "+i);
            }
            System.out.println("@#$ "+i);


        }else if (type==3){

            int i=geLiService.delectOneById(typeId);
            if (i>=1) {
                map.put( "msg", "删除成功" );
            }else {
                map.put("msg", "删除失败");
                System.out.println("@#$ "+i);
            }
            System.out.println("@#$ "+i);


        }else if (type==4){

            int i =guiJiService.delectManyByOrderId(orderId);
            if (i>=1) {
                map.put( "msg", "删除成功" );
            }else {
                map.put("msg", "删除失败");
                System.out.println("@#$ "+i);
            }
            System.out.println("@#$ "+i);

        }

        int i = orderService.delectOneById( orderId );
        System.out.println("@#$orderId "+orderId +" i: "+i);

        return map;

    }









}
