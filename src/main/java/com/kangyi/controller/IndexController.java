package com.kangyi.controller;

import com.kangyi.mapper.UserMapper;
import com.kangyi.pojo.Menu;
import com.kangyi.pojo.User;
import com.kangyi.pojo.UserExample;
import com.kangyi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.kangyi.constant.Constant.YOUKEID;

//@RequestMapping("/a")
@Controller
public class IndexController {



        @Autowired
    private UserMapper userMapper;


    @Autowired
    private MenuService menuService;



    @RequestMapping(value = {"/","/index"})
    public String index(
            HttpSession session1, Model model

    ){


        System.out.println("index@@@@@getId2 :"+session1.getId());
        User user = (User) session1.getAttribute("userInfo");

        Long roleId ;
        if (user!=null){
            roleId=user.getRoleId();
        }else {roleId = YOUKEID;}

        List<Menu> menuList = menuService.selectMenuListByRoleId(roleId);
        session1.setAttribute("menuList",menuList);
        return "jsp/index";
    }
    @RequestMapping("/erro")
    public String error(){
        return "jsp/error";
    }
}
