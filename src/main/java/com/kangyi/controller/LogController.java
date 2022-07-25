package com.kangyi.controller;

import com.kangyi.service.LogService;
import com.kangyi.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/log")
@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @RequiresPermissions(value = {"permission:query"})
    @RequestMapping("/list")
    public String logList(){
        return "jsp/system/log/list";
    }

    @RequestMapping("/list/page")
    @RequiresPermissions("permission:query")
    @ResponseBody
    public Result getListForPage(
            @RequestParam(value = "pno",defaultValue = "1") int pno,
            @RequestParam(value = "psize",defaultValue = "10") int psize,
            @RequestParam(value = "url",defaultValue = "") String url,
            @RequestParam(value = "username",defaultValue = "") String username,
            @RequestParam(value = "action",defaultValue = "") String action,
            @RequestParam(value = "beginTime",defaultValue = "") String beginTime,
            @RequestParam(value = "endTime",defaultValue = "") String endTime,
            @RequestParam(value = "sortField",defaultValue = "") String sortField,
            @RequestParam(value = "sortType",defaultValue = "") String sortType

    ){
        return logService.getListForPage(pno,psize,url,username,action,beginTime,endTime,sortField,sortType);
    }



}
