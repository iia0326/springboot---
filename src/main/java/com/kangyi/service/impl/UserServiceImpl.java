package com.kangyi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import com.kangyi.pojo.Dept;
import com.kangyi.mapper.UserMapper;
import com.kangyi.pojo.Menu;
//import com.kangyi.mapper.DeptMapper;
import com.kangyi.mapper.MenuMapper;
import com.kangyi.pojo.User;
import com.kangyi.pojo.UserExample;
import com.kangyi.service.UserService;
import com.kangyi.util.ChangeChar;
import com.kangyi.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static com.kangyi.constant.Constant.YONGHUID;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;
    


    @Override
    public String getUserList() {
        UserExample userEx = new UserExample();
        UserExample.Criteria criteria = userEx.createCriteria();
        criteria.andUsernameLike("admin");
        List<User> list = userMapper.selectByExample(userEx);
        return JSONObject.toJSONString(list);
    }

    @Override
    public String getMenuListForPage(int pno, int psize) {
        Page<Menu> p = PageHelper.startPage(pno, psize);
        List<Menu> list = menuMapper.selectByExample(null);
        PageInfo<Menu> page = new PageInfo<Menu>(list);
        JSONObject j = new JSONObject();
        System.out.println(page.getList());
        System.out.println(page.getPages());
        j.put("list",page.getList());
        j.put("page",page);
        return j.toJSONString();
    }

    @Override
    public List<Menu> testList(int pno, int psize, Model model) {
        Page<Menu> p = PageHelper.startPage(pno, psize);
        List<Menu> list = menuMapper.selectByExample(null);
        Page<Menu> page = (Page)list;
//        System.out.println(p.getTotal());
//        System.out.println(p.getResult());
//        System.out.println(p.getPages());
//        System.out.println(page.getResult());
//        System.out.println(page.getPages());
//        System.out.println(page.getTotal());
//        System.out.println(page.getResult().get(0));
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        model.addAttribute("pageSize",page.getPageSize());
        model.addAttribute("pages",page.getPages());
        model.addAttribute("total",page.getTotal());
        return page;
    }

    @Override
    public User findByUsername(String userName) {

        UserExample ex = new UserExample();
        UserExample.Criteria cri = ex.createCriteria();
        cri.andUsernameEqualTo(userName);
        List<User> list = userMapper.selectByExample(ex);
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public User login(String username, String password, HttpServletRequest request) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        User u = null;
        try {
            currentUser.login(token);

            u = (User)currentUser.getPrincipals().getPrimaryPrincipal();
            request.getSession().setAttribute("userInfo",u);
//            System.out.println("login@@@@@getId1 :"+request.getSession().getId());


        }catch (UnknownAccountException e) {
            System.out.println("账号不存在");
        } catch (IncorrectCredentialsException e) {
            System.out.println("2 username "+username+"  password="+password);
            System.out.println("密码不正确");
        } catch (AuthenticationException e) {
            System.out.println("用户验证失败");
        }

        return u;
    }

    @Override
    public Result getListForPage(int pno, int psize, String username, String sortField, String sortType) {
        Page<User> p = PageHelper.startPage(pno, psize);
        UserExample ue = new UserExample();
        UserExample.Criteria userCriteria = ue.createCriteria();
        if(username.trim().length()>0){
            userCriteria.andUsernameLike("%"+username+"%");
        }
        if(sortField.trim().length()>0){
            ue.setOrderByClause(ChangeChar.camelToUnderline(sortField,2) +" " +sortType);

        }

        userMapper.selectAllByExampleForPage(ue);



        return Result.end(200,p.getResult(),"查询成功",p.getTotal());
    }

    @Override
    public int insertUser(User user) {
        if(user.getRoleId()==null){
            user.setRoleId( YONGHUID );
        }
        user.setInsertTime(new Date());
        user.setAge(0);
        String oldPassword = user.getPassword();
        SimpleHash newPassword = new SimpleHash("MD5", oldPassword, "abc", 2);
        user.setPassword(newPassword.toString());
        int i = userMapper.insert( user );
        return  i;
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void editUser(User user) {
        String oldPassword = user.getPassword();
        SimpleHash newPassword = new SimpleHash("MD5", oldPassword, "abc", 2);
        user.setPassword(newPassword.toString());
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String changePassword(HttpSession session, User user, Model model) {
        String password = user.getPassword();
        String password1 = user.getPassword1();
        String password2 = user.getPassword2();
        if(password == null || password.trim().length()==0){
            model.addAttribute("error",true);
            model.addAttribute("msg","原密码不可以为空");
            return "jsp/system/password/password";
        }
        UserExample ue = new UserExample();
        UserExample.Criteria criteria = ue.createCriteria();
        SimpleHash passwordDecoded = new SimpleHash("MD5", password, "abc", 2);
        criteria.andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(passwordDecoded.toString());
        List<User> list = userMapper.selectByExample(ue);
        model.addAttribute("formData",user);
        if(list.size() == 0){
            model.addAttribute("error",true);
            model.addAttribute("msg","原密码不正确");
            return "jsp/system/password/password";
        }
        if(password.equals(password1)){
            model.addAttribute("error",true);
            model.addAttribute("msg","原密码和新密码相同");
            return "jsp/system/password/password";
        }
        if(!password1.equals(password2)){
            model.addAttribute("error",true);
            model.addAttribute("msg","两次输入的密码不一致");
            return "jsp/system/password/password";
        }
        SimpleHash password1Decoded = new SimpleHash("MD5", password1, "abc", 2);
        user.setPassword(password1Decoded.toString());
        userMapper.updateByPrimaryKeySelective(user);
//        session.invalidate();
        model.addAttribute("complete",true);
        return "jsp/system/password/password";
    }



    @Override
    public List<User> selectAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public List<User> selectUname(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo( username );
        List<User> users = userMapper.selectByExample( userExample );
        return users;
    }
}
