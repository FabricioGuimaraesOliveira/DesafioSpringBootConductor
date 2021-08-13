package com.conductor.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.conductor.demo.interceptor.RegistroInterceptor;

@Configuration
public class RegistroConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RegistroInterceptor()).addPathPatterns("/v1.0/**");
    }
}
