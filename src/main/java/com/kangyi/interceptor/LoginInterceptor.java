package com.kangyi.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  HandlerInterceptor 在springmvc框架中使用过
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //我们要做一个登录拦截，如果不登录就不让你访问后台页面
        //登录成功不是的存储session对象吗，没有session就是没登录过呗
        HttpSession session = request.getSession();
        //从session中获取user对象，查询是否为null
        Object user = session.getAttribute("user");
        //如果user是null ，说明 没登录过
        if(user == null){
            //设置提示信息
            request.setAttribute("msg","您没有权限，请登录");
            //转发到 登录页面
            request.getRequestDispatcher("/index").forward(request,response);
            //response.sendRedirect("/index");
            //拦截了，不让你进入到 controller中
            return false;
        }
        //如果user不是null ，那么就是登录过，直接放行就可以了，跳转到controller
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
