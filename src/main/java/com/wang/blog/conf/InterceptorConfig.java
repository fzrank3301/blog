package com.wang.blog.conf;

import com.wang.blog.Interceptor.Testinterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    Testinterceptor testinterceptor;

    //给所有路由加上Testinterceptor的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testinterceptor).addPathPatterns("/**");
//         也可以添加多个拦截器
//        registry.addInterceptor(new 1TestinterCeptor);
    }
}
