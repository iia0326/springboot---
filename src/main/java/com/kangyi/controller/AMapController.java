package com.kangyi.controller;

import com.kangyi.pojo.*;
import com.kangyi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;


@RestController
@RequestMapping(path = "/map")
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L)
//@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
//        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class AMapController {

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


     @GetMapping
    @PostMapping
    @RequestMapping(path = "/index")
//    @ResponseBody
    public Map<String, Object> getList(

            @RequestParam(value = "dbWeiDu",defaultValue = "") String dbWeiDu,
            @RequestParam(value = "dbJingDu",defaultValue = "") String dbJingDu,
            @RequestParam(value = "xnWeiDu",defaultValue = "") String xnWeiDu,
            @RequestParam(value = "xnJingDu",defaultValue = "") String xnJingDu,
            @RequestParam(value = "etime",defaultValue = "") String etime,
            @RequestParam(value = "btime",defaultValue = "") String btime,
            @RequestParam(value = "tian",defaultValue = "") Integer tian,
            @RequestParam(value = "type",defaultValue = "") Integer type

     ) {
         Map<String, Object> map = new HashMap<>(3);




             BigDecimal bigWeiDu = new BigDecimal( dbWeiDu );
             BigDecimal smallWeiDu = new BigDecimal( xnWeiDu );
             BigDecimal bigJingDu = new BigDecimal( dbJingDu );
             BigDecimal smalJingDu = new BigDecimal( xnJingDu );

           if (type == null) {
//             System.out.println("@#$bjingdu"+bigWeiDu);
//             List<Long> orders=OrderService.selectOrderByStatus(2);
                 List<HeSuan> heSuanList = heSuanService.selectManyByJingWeiDu( bigWeiDu, smallWeiDu, bigJingDu, smalJingDu,etime,btime );
                 map.put( "1", heSuanList );
                 List<YiMiao> yiMiaoList = yiMiaoService.selectManyByJingWeiDu( bigWeiDu, smallWeiDu, bigJingDu, smalJingDu,etime,btime );
                 map.put( "2", yiMiaoList );
                 List<GeLi> geLiList = geLiService.selectManyByJingWeiDu( bigWeiDu, smallWeiDu, bigJingDu, smalJingDu,etime,btime );
                 map.put( "3", geLiList );
                 List<GuiJi> guiJiList = guiJiService.selectManyByJingWeiDu( bigWeiDu, smallWeiDu, bigJingDu, smalJingDu,etime,btime,tian );
                 map.put( "4", guiJiList );

             }else if (type == 1) {
                 List<HeSuan> heSuanList = heSuanService.selectManyByJingWeiDu( bigWeiDu, smallWeiDu, bigJingDu, smalJingDu, etime, btime );
                 map.put( "1", heSuanList );

             } else if (type == 2) {
               List<YiMiao> yiMiaoList = yiMiaoService.selectManyByJingWeiDu( bigWeiDu, smallWeiDu, bigJingDu, smalJingDu, etime, btime );
               map.put( "2", yiMiaoList );

             } else if (type == 3) {
               List<GeLi> geLiList = geLiService.selectManyByJingWeiDu( bigWeiDu, smallWeiDu, bigJingDu, smalJingDu, etime, btime );
               map.put( "3", geLiList );

             } else if (type == 4) {
               List<GuiJi> guiJiList = guiJiService.selectManyByJingWeiDu( bigWeiDu, smallWeiDu, bigJingDu, smalJingDu, etime, btime, tian );
               map.put( "4", guiJiList );
             }



//        return orderService.getListForPage( type,btime,etime,pno,psize,userId,sortField,sortType );
         return map;
    }












}
