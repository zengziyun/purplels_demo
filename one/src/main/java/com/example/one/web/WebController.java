package com.example.one.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
public class WebController {

    @RequestMapping("/welcome")
    public String welcome(Map<String,Object> map) {
        map.put("time",new Date());
        map.put("massage","Hello springBoot");
        return "hello";
    }

    @GetMapping("/user")
    public String user(Map<String, Object> model, HttpServletRequest request) {
        model.put("username", "neo");
        model.put("salary", 666);
        request.getSession().setAttribute("count",6);
        return "user";
    }
}
