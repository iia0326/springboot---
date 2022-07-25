package com.kangyi;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.server.session.DefaultWebSessionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import java.util.Collections;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
//@ComponentScan({"com.*"})
@MapperScan(basePackages = "com.kangyi.mapper")
public class Kangyi01Application extends SpringBootServletInitializer  {

///extends SpringBootServletInitializer
//    DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();

//System.out.println(defaultWebSessionManager.isSessionIdUrlRewritingEnabled()); // true
//defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
//System.out.println(defaultWebSessionManager.isSessionIdUrlRewritingEnabled());
//
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        super.onStartup(servletContext);
//        servletContext.setSessionTrackingModes(
//                Collections.singleton( SessionTrackingMode.COOKIE));
//        SessionCookieConfig sessionCookieConfig =
//                servletContext.getSessionCookieConfig();
//        sessionCookieConfig.setHttpOnly(true);
//    }

    public static void main(String[] args) {
        SpringApplication.run( Kangyi01Application.class, args );
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources( Kangyi01Application.class );
    }
}
