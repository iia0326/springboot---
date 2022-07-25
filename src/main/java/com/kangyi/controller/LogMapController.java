package com.kangyi.controller;

import com.kangyi.pojo.LogMap;
import com.kangyi.service.LogMapService;
import com.kangyi.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/log-map")
@Controller
public class LogMapController {

    @Autowired
    private LogMapService logMapService;

    @RequiresPermissions(value = {"permission:query"})
    @RequestMapping("/list")
    public String logMapList(){
        return "jsp/type/log-map/list";
    }


    @RequestMapping("/list/page")
    @RequiresPermissions("permission:query")
    @ResponseBody
    public Result getListForPage(
            @RequestParam(value = "pno",defaultValue = "1") int pno,
            @RequestParam(value = "psize",defaultValue = "10") int psize,
            @RequestParam(value = "url",defaultValue = "") String url,
            @RequestParam(value = "sortField",defaultValue = "") String sortField,
            @RequestParam(value = "sortType",defaultValue = "") String sortType

    ){
        return logMapService.getListForPage(pno,psize,url,sortField,sortType);
    }

    @RequestMapping("/add/page")
    public String logMapAddPage(){
        return "jsp/type/log-map/add";
    }
    @RequestMapping("/edit/page")
    public String logMapEditPage(Long id, Model model){
        LogMap logMap = logMapService.selectLogMapById(id);
        model.addAttribute("formData",logMap);
        return "type/log-map/edit";
    }

    @RequestMapping("/add")
    public String logMapAdd(LogMap logMap){
        logMapService.insertLogMap(logMap);
        return "redirect:/log-map/list";
    }

    @RequestMapping("/edit")
    public String logMapEdit(LogMap logMap){
        logMapService.updateLogMap(logMap);
        return "redirect:/log-map/list";
    }

    @RequestMapping("/delete")
    public String logMapDelete(Long id){
        logMapService.deleteLogMapById(id);
        return "redirect:/log-map/list";
    }
}
