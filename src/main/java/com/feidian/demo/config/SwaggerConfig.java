package com.feidian.demo.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.print.Doc;
import java.util.ArrayList;

@Configuration
@EnableSwagger2//开启swagger2
public class SwaggerConfig {


    @Bean
    public Docket docket(){

//        public Docket docket(Environment Object environment;
//        environment){
//            Profiles profiles = Profiles.of( "dev");
//            //获取项目的环境：
//        }
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("沸点")
                .enable(true)
                .select()
                //requestHandlerSelectors,配置要扫描接口的方法
                //basePackage:指定扫描的包
                //any()扫描全部
                //none()不扫描
                //withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                //withClassAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //.apis(RequestHandlerSelectors.any()
                //.path()过滤一个路径
                .build();//
    }
    //配置swagger信息=apiInfo
    private  ApiInfo apiInfo(){
        Contact contact = new Contact("feidian","","");
        return new ApiInfo("沸点wiki",
                "Api Documentation",
                "v1.0",
                "",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}
