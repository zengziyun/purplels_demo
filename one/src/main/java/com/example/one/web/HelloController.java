package com.example.one.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //当前注解可以直接把返回的参数解析成json数据
public class HelloController {

    @RequestMapping(value = "/hello")
    public String setHello(String name) {
        return "Hello World："+name+",测试";
    }
}
