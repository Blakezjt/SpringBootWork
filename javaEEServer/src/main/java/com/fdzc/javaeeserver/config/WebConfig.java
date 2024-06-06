package com.fdzc.javaeeserver.config;

import com.fdzc.javaeeserver.interceptors.LoginInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//注册拦截器
//@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptors loginInterceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录接口和注册接口不拦截   excludePathPatterns()不拦截()里面的路径
        registry.addInterceptor(loginInterceptors).excludePathPatterns("/user/login","user/register");
    }
}
