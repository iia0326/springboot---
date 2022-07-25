package com.kangyi.config;

//import com.moju.interceptor.LoginInterceptor;
import com.kangyi.shiro.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static jdk.nashorn.internal.objects.Global.undefined;

/**
 * 使用java配置类 ，替换beans.xml
 */
@Configuration
public class MyConfig  implements WebMvcConfigurer {
    /**
     * 把我们自己写的工具类，添加到springboot的容器中
     * @return  拓展组件  多态的思想
     */

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(HandleResourceViewExists.class); //设置检查器
        System.out.println("+++++++jsp");
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(0);
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }

    @Bean
    public InternalResourceViewResolver htmlViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setViewClass(HandleResourceViewExists.class); //设置检查器
        System.out.println("+++++++html");
        viewResolver.setSuffix(".html");
        viewResolver.setOrder(0);
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }







    //向springboot中添加额外的组件 ，需要添加web莫块儿的自动配置
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }

    /**
     * 添加shiro的功能
     *
     */


    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(manager);
        //设置登录页面
        factoryBean .setLoginUrl( "/index" );
        //未授权页面
        factoryBean .setUnauthorizedUrl( "/index"  );


        /*认证过滤器：
    anon：无需认证即可访问，游客身份。
    authc：必须认证（登录）才能访问。
    authcBasic：需要通过 httpBasic 认证。
    user：不一定已通过认证，只要是曾经被 Shiro 记住过登录状态的用户就可以正常发起请求，比如 rememberMe。

    授权过滤器:
    perms：必须拥有对某个资源的访问权限（授权）才能访问。
    role：必须拥有某个角色权限才能访问。
    port：请求的端口必须为指定值才可以访问。
    rest：请求必须是 RESTful，method 为 post、get、delete、put。
    ssl：必须是安全的 URL 请求，协议为 HTTPS。*/
        Map<String,String> map = new HashMap<>();
//        map.put("/main","authc");
//        map.put("/manage","perms[manage]");
//        map.put("/administrator","roles[administrator]");
        map.put("/login/admin","anon");
        map.put("/login/page","anon");
        map.put("/css/**","anon");
        map.put("/image/**","anon");
        map.put("/public/**","anon");
        map.put("/js/**","anon");
        map.put("/layui/**","anon");
//        map.put("/**","authc");

        map.put("/user/list","anon");
        map.put("/user/list","anon");
        map.put("/sq/geli","anon");
        map.put("/index","anon");
        map.put("/aaa","anon");
//        map.put("/a/index","anon");
//        map.put("","anon");
//        map.put("","anon");



        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }


    @Bean
    public DefaultWebSecurityManager manager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }

    @Bean
    public UserRealm userRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher hcm){
        UserRealm ur = new UserRealm();
        ur.setCredentialsMatcher( hcm );
        return ur;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hcm = new HashedCredentialsMatcher();
        hcm.setHashAlgorithmName( "MD5" );
        hcm.setHashIterations( 2 );
        return hcm;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor( );
    }
//    @Bean
//    public GlobalLogInceptor globalLogInceptor(){
//        return new GlobalLogInceptor( );
//    }

}
