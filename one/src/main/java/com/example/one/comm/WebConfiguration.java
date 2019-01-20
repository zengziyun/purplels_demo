package com.example.one.comm;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class WebConfiguration {

    /**
     * 设置拦截器
     * */
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        bean.addUrlPatterns("/*");
        bean.setName("MyFilter");
        /**
         * order值越小优先级越高
         * */
        bean.setOrder(6);
        return bean;
    }
}
