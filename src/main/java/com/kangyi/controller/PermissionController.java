package com.kangyi.controller;

import com.kangyi.pojo.Permission;
import com.kangyi.service.PermissionService;
import com.kangyi.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/permission")
@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    @RequiresPermissions(value = {"permission:query"})
    @RequestMapping("/list")
    public String permissionList(){
        return "jsp/system/permission/list";
    }
    @RequiresPermissions(value = {"permission:query"})
    @RequestMapping("/list/page")
    @ResponseBody
    public Result permissionListPage(
            @RequestParam(value = "pno",defaultValue = "1")int pno,
            @RequestParam(value = "psize",defaultValue = "10")int psize,
            @RequestParam(value = "sortField",defaultValue = "") String sortField,
            @RequestParam(value = "sortType",defaultValue = "") String sortType
    ){
        return permissionService.selectPermissionListForPage(pno,psize,sortField,sortType);
    }

    @RequestMapping("/add/page")
    public String permissionAddPage(){
        return "jsp/system/permission/add";
    }

    @RequestMapping("/add")
    public String permissionAdd(Permission permission){
        permissionService.insertPermission(permission);
        return "redirect:/permission/list";
    }

    @RequestMapping("/edit/page")
    public String permissionEditPage(Long id, Model model){

        Permission permission = permissionService.selectPermissionById(id);
        model.addAttribute("formData",permission);
        return "jsp/system/permission/edit";
    }

    @RequestMapping("/edit")
    public String permissionEdit(Permission permission){
        permissionService.updatePermissionById(permission);
        return "redirect:/permission/list";
    }

    @RequestMapping("/delete")
    public String permissionDelete(Long id){
        permissionService.deletePermissionById(id);
        return "redirect:/permission/list";
    }
}
