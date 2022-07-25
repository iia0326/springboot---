package com.kangyi.controller;

import com.kangyi.pojo.Role;
import com.kangyi.pojo.User;
import com.kangyi.service.RoleService;
import com.kangyi.service.UserService;
import com.kangyi.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    @RequestMapping("/list")
    @RequiresPermissions(value = {"permission:query"})
    public String userList(

            @RequestParam(value = "username",defaultValue = "") String username,
            Model model
    ){
        model.addAttribute("username",username);
        return "jsp/system/user/list";
    }




    @RequestMapping("/list/page")
    @RequiresPermissions("permission:query")
    @ResponseBody
    public Result getUserListForPage(
            @RequestParam(value = "pno",defaultValue = "1") int pno,
            @RequestParam(value = "psize",defaultValue = "10") int psize,
            @RequestParam(value = "username",defaultValue = "") String username,
            @RequestParam(value = "sortField",defaultValue = "") String sortField,
            @RequestParam(value = "sortType",defaultValue = "") String sortType

    ){
        System.out.println(sortField+" :sortField  ! sortType:"+sortType);
        return userService.getListForPage(pno,psize,username,sortField,sortType);
    }


    @RequestMapping("/add/page")
    public String userAddPage(Model model){

        List<Role> roleList = roleService.selectRoleListAll();
        model.addAttribute("roleList",roleList);
        return "jsp/system/user/add";
    }
    @RequestMapping("/edit/page")
    public String userEditPage(Long id, Model model){
        User user = userService.findUserById(id);
        List<Role> roleList = roleService.selectRoleListAll();
        model.addAttribute("formData",user);
        model.addAttribute("roleList",roleList);
        return "jsp/system/user/edit";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Map<String,String> userAdd(User user){
        HashMap<String, String> map = new HashMap<>();
        System.out.println(user);
        int i = userService.insertUser( user );
        if (i>=1) {
            map.put( "msg", "注册成功 " );
        }else { map.put("msg", "注册失败");}
        return map;
    }

    @RequestMapping("/getuname")
    @ResponseBody

    public String getusername(String username){
//        HashMap<String, String> map = new HashMap<>();
        System.out.println(username);
        List<User> userList=userService.selectUname(username);

        if (userList.size()>=1) {
//            map.put( "username","1" );
//            map.put( "msg", "已经存在，不可用 " );
            return "1";
        }else {
//            map.put("msg", "未存在，可用");
//            map.put( "username","0" );
            return "0";
        }

    }


    @RequestMapping("/edit")
    public String userEdit(User user){
        System.out.println(user);
        userService.editUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String userDelete(Long id){
        userService.deleteUserById(id);
        return "redirect:/user/list";
    }

    @RequestMapping("/password/page")
    public String userPasswordPage(HttpSession session, Model model){
        User user  = (User)session.getAttribute("userInfo");
//        user.setPassword("");
        model.addAttribute("formData",user);
        return "jsp/system/password/password";
    }

    @RequestMapping("/password/change")
    public String userPasswordChange(HttpSession session, Model model, User user){
        return userService.changePassword(session,user,model);
    }
}
