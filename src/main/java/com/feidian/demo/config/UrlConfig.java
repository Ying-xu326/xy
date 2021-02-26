package com.feidian.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UrlConfig implements WebMvcConfigurer {
    @Value("${upload_imgs_folder}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/work/Images/**").addResourceLocations("file:" + uploadDir + "work/");
        registry.addResourceHandler("/team/Images/**").addResourceLocations("file:" + uploadDir + "team/");
        registry.addResourceHandler("/member/Images/**").addResourceLocations("file:" + uploadDir + "member/");
    }
}