package com.kangyi.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import com.kangyi.pojo.Menu;
import com.kangyi.pojo.User;
import com.kangyi.service.MenuService;
import com.kangyi.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kangyi.constant.Constant.YOUKEID;

@RequestMapping("/login")
@Controller
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    private LineCaptcha lineCaptcha;


    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response) {

        // 定义图形验证码的长和宽
//        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(100, 30);
// 图形验证码写出，可以写出到文件，也可以写出到流
//        String code = lineCaptcha.getCode();

        // 随机生成 4 位验证码
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        // 定义图片的显示大小
         lineCaptcha = CaptchaUtil.createLineCaptcha(100, 30);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try {
            // 调用父类的 setGenerator() 方法，设置验证码的类型
            lineCaptcha.setGenerator(randomGenerator);
            // 输出到页面
            lineCaptcha.write(response.getOutputStream());
            // 打印日志
//            logger.info("生成的验证码:{}", lineCaptcha.getCode());
            // 关闭流
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/page")
    public String login(){
        return "jsp/login";
    }

    @RequestMapping("/registerPage")
    public String registerPage(){
        return "jsp/register";
    }

    @CrossOrigin(origins="*",allowCredentials = "true")
    @RequestMapping("/admin")
    public String loginAdmin(
          @RequestParam("username") String username,
          @RequestParam("password") String password,
          @RequestParam("imgCode") String imgCode,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            Model m){


        System.out.println("@#$admin; "+username+" psd: "+password);
        String code = lineCaptcha.getCode();
        if(!code.equals( imgCode )){
            m.addAttribute("code",false);
            return "jsp/login";
        }
        User u = userService.login(username,password,request);

        System.err.println(u);
        if(u == null){


            m.addAttribute("success",false);
            return "jsp/login";

        }else{
            List<Menu> menuList = menuService.selectMenuListByRoleId(u.getRoleId());
//            HttpSession session = request.getSession();
            session.setAttribute("menuList",menuList);
            session.setAttribute( "user",u );
            session.setAttribute( "userId",u.getId() );

            Cookie cookie = new Cookie( "userId", String.valueOf(u.getId()));
            cookie.setPath("/");
            System.out.println(cookie+"   is cookie");
            response.addCookie(cookie);


            System.out.println("  usid  "+session.getAttribute( "userId" ));
            m.addAttribute("success",true);
            return "forward:/index";

        }

    }

    @RequestMapping("/chectUserName")
    @ResponseBody
    public String chectUserName(String username){
//        String mag="用户名已存在";
        if(username!=null&&!"".equals( username )) {
            User user = userService.findByUsername( username );
            if(user==null){
//                mag="用户名可用";
                return "{result:false}";
            }
        }
        return "{result:true}";
    }


    @RequestMapping("/register")

    public String register(Model m,
                           HttpSession session,
                           HttpServletRequest request,
                           HttpServletResponse response,
                           User user){

        System.out.println(user);
//        String pssword=user.getPassword();
        String code = lineCaptcha.getCode();

        if(!code.equals( user.getImgCode() )){
            m.addAttribute("code",false);
            return "jsp/register";
        }

        if(user.getUsername()!=null) {
            User u = userService.findByUsername( user.getUsername() );
            if(u!=null){
                m.addAttribute("name",false);
                return "jsp/register";
            }
        }

        if (user.getPassword().equals( user.getPassword1() )){


            int i = userService.insertUser( user );
            if (i>=1) {
                 System.out.println("@#$注册成功");
            }else {
            System.out.println("@#$注册失败");
                return "jsp/register";
            }

            //直接登录
            User u = userService.login(user.getUsername(),user.getPassword1(),request);
            if(u == null){
                m.addAttribute("success",false);
                return "jsp/register";
            }
            List<Menu> menuList = menuService.selectMenuListByRoleId(u.getRoleId());
//            HttpSession session = request.getSession();
            session.setAttribute("menuList",menuList);
            session.setAttribute( "user",u );
            session.setAttribute( "userId",u.getId() );

            Cookie cookie = new Cookie( "userId", String.valueOf(u.getId()));
            cookie.setPath("/");
            System.out.println(cookie+"   is cookie");
            response.addCookie(cookie);
            System.out.println("  usid  "+session.getAttribute( "userId" ));
            m.addAttribute("success",true);
            return "forward:/index";
        }else {
            return "jsp/register";
        }
    }


    @CrossOrigin(origins="*",allowCredentials = "true")
    @GetMapping
    @RequestMapping("/getuser")
    @ResponseBody
    //先请求的userId,再session,没有才看cookit,
    public User getuser(
//                            @RequestParam("username") String username,
//                             @RequestParam("password") String password,
                             HttpServletRequest request,
                             HttpServletResponse response,
                             HttpSession session,
                             @CookieValue(value = "userId",required=false ,defaultValue ="-1"  ) Long userId,
                             @RequestParam(value = "userId",required=false,defaultValue ="-1" ) Long url_userId,
                             @CookieValue(value ="JSESSIONID",required=false) String JSESSIONID,
                             Model m){
        System.out.println("index@@@@@getId3 :"+session.getId());
        User u = new User();
        //  取url上的userid
        if(url_userId!=null&& url_userId>0l) {
            u = userService.findUserById( url_userId );
            if(u==null){
                u = new User();
                u.setId( url_userId );
            }
//取session、cookit的
        }else {
            u = (User) session.getAttribute("userInfo");
            System.err.println("当前用户 ："+u);

            if (u == null){


                if(userId > 0l && userId != null){ u = userService.findUserById( userId );}
                if(u==null){
                    u = new User();
                    u.setId( userId > 0l ? url_userId : -3l);
                }
            }
        }



       return u;

    }

    @RequestMapping("/logout")
    public String logout( HttpServletRequest request,
//                          Cookie cookie,
                          HttpServletResponse response){
        //将`Max-Age`设置为0
        Cookie cookie2 = new Cookie( "userId", "-2");
        cookie2.setPath("/");
        response.addCookie(cookie2);

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index";
    }
}
