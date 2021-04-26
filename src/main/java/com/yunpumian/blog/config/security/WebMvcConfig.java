package com.yunpumian.blog.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-20 16:34
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/login").setViewName("/login");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 释放静态资源
         */
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\";
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + path);


    }
}
