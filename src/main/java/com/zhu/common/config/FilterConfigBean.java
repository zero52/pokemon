package com.zhu.common.config;/*
2019/11/27
41586
*/

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfigBean {

    @Bean
    public FilterRegistrationBean customerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();

        // 设置过滤器
        registration.setFilter(new CustomerFilter());

        // 拦截路由规则
        registration.addUrlPatterns("/pokemon");
//        registration.addUrlPatterns("/pokemon/pokemon/*");
//        registration.addUrlPatterns("/pokemon/skill/*");
//        registration.addUrlPatterns("/pokemon/ability/*");
//        registration.addUrlPatterns("/pokemon/manage");

        // 设置初始化参数
        registration.addInitParameter("name", "customFilter");

        registration.setName("CustomerFilter");
        registration.setOrder(1);
        return registration;
    }

}
