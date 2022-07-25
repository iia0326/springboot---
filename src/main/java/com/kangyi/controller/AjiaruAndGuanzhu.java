package com.kangyi.controller;


import com.kangyi.pojo.*;
import com.kangyi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/jiaruAndGuanzhu")
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L)
public class AjiaruAndGuanzhu {

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
    @ResponseBody
    public Map<String, Object> getBokeList(
//            @RequestBody  Map<String, Object> data,
              @RequestParam(value = "pno",defaultValue = "1") Integer pno,
             @RequestParam(value = "psize",defaultValue = "10") Integer psize,
             @RequestParam(value = "type",defaultValue = "0") Integer type,
             @RequestParam(value = "messageType",defaultValue = "") Integer messageType,
//             @RequestParam(value = "orderId",defaultValue = "") Long orderId,
             @RequestParam(value = "etime",defaultValue = "null") String etime,
            @RequestParam(value = "btime",defaultValue = "null") String btime,
             @RequestParam(value = "userId",defaultValue = "") Long userId,
               @RequestParam(value = "sortField",defaultValue = "createTime") String sortField,
            @RequestParam(value = "sortType",defaultValue = "desc") String sortType
           ) {
//        Map<String, Object> map = new HashMap<>(3);
//        Integer type = (Integer) data.get( "type" );
//        Integer pno = (Integer) data.get( "pno" );
//        Integer psize = (Integer) data.get( "psize" );
//        Integer messageType = (Integer) data.get( "messageType" );
//        Long userId = Long.valueOf( String.valueOf( data.get("userId")) );
//        String btime = String.valueOf( data.get( "btime" ) );
//        String etime = String.valueOf( data.get( "etime" ) );
//
//        if (pno == null) {
//            pno = 1;
//        }
//        if (psize == null) {
//            psize = 10;
//        }
//        if (type == null) {
//            type = 0;
//        }
//        String sortField = "insertTime";
//        String sortType = "desc";
//        String.valueOf( data.get( "sortType" ) )
//        String.valueOf( data.get( "sortField" ) )


        if ("ascend".equals( sortType )) {
            sortType = "asc";
        } else if ("descend".equals( sortType)) {
            sortType = "desc";
        }

//        if (data.get( "sortField" ) != null) {
//            sortField =  String.valueOf( data.get( "sortField" ) );
//        }

        List<Jiaru> jiaruList = jiaruService.selectManyByStatusUserId( 2, userId, -1, sortField, sortType, type );
        List<Guanzhu> guanzhuList = guanzhuService.selectManyByStatusUserId( 1, userId );
        List<Long> jOrderList = new ArrayList<>(  );
        List<Long> gOrderList = new ArrayList<>(  );
        Map<String, Object> jListForPage = new HashMap<>(  );
        Map<String, Object> gLstForPage = new HashMap<>(  );

        //jiaru
        if (jiaruList!=null&&jiaruList.size()>0) {
            for (Jiaru j : jiaruList) {
                Long orderId = j.getOrderId();
                jOrderList.add( orderId );
            }
            jListForPage = orderService.getListForPageByIdList( type, btime, etime, pno, psize, jOrderList, "insertTime", sortType, "jiaru" );

        }

        //guanzhu
        if (guanzhuList!=null||guanzhuList.size()>0) {
            System.out.println("@#$guanzhuListSize "+guanzhuList.size());
            System.out.println("@#$guanzhuList "+guanzhuList);
            for (Guanzhu j : guanzhuList) {
                Long orderId = j.getOrderId();
                gOrderList.add( orderId );
            }
            gLstForPage = orderService.getListForPageByIdList( type, btime, etime, pno, psize, gOrderList, "insertTime", sortType, "guanzhu" );
//        jListForPage = orderService.getListForPageByIdList( type, btime, etime, pno, psize, jOrderList, sortField, sortType, "jiaru" );
        }
        if (messageType == 2) {
            //jiaru

            return jListForPage;

        } else if (messageType == 1) {
            //guanzhu
            return gLstForPage;

        } else {
            //都
            Map<String, Object> combineResultMap = new HashMap<String, Object>();
            combineResultMap.putAll( jListForPage );
            combineResultMap.putAll( gLstForPage );
            return combineResultMap;

        }
    }

}
