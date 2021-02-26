package com.feidian.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.WebApplicationInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@MapperScan("com.feidian.demo.dao")
@ImportResource(locations = {"classpath:/kaptcha.xml"})
@EnableSwagger2
public class
DemoApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
    //	打包war需要这个启动类，发布到服务器上
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(DemoApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
