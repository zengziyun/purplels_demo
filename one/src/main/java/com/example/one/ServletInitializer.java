package com.example.one;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 需要打成war包运行时 添加当前类
 * 继承SpringBootServletInitializer
 * 当前方法是用于外部tomcat的servlet支持
 * */
/*public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OneApplication.class);
    }
}*/
