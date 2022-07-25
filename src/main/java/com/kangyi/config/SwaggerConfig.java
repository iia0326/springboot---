package com.kangyi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ljh
 * @create 2022-04-21 17:50
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).
// 指定构建 api 文档的详细信息的方法：
                //是否开启 (true 开启  false隐藏。生产环境建议隐藏)
                //.enable(false)
        apiInfo(apiInfo()).apiInfo(apiInfo())
                .select()
// 指定要生成 api 接口的包路径，这里把 controller 作为包路径，生成 controller 中的所有接口
                //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                .apis(RequestHandlerSelectors.basePackage("com.kangyi"))
                //指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api 文档的详细信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
// 设置页面标题
 //设置文档标题(API名称)
                .title("便民战疫-->接口文档")
                //文档描述
//                .description("接口说明")
                //服务条款URL
                .termsOfServiceUrl("http://localhost:8083/")
                .contact(new Contact("便民战疫项目开发", "http://localhost:8083/", "386954494@qq.com"))
                // 设置接口描述
                .description("我的Api")
// 设置版本
                .version("1.0")
// 构建
                .build();
    }
}