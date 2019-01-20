package com.example.one.web;

import com.example.one.comm.NeoProperties;
import com.example.one.model.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Value("${neo.title}")
    private String title;

    @Resource
    private NeoProperties properties;
    /*@RequestMapping(name = "/getUser")
    public User getUser() {
        User user = new User();
        user.setAge(18);
        user.setName("天平");
        user.setPass("1234456");
        return user;
    }*/

   /* @RequestMapping(name = "/getUserList")
    public List<User> getUserList() {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setAge(18);
        user1.setName("天平");
        user1.setPass("1234456");
        list.add(user1);
        User user2 = new User();
        user2.setAge(18);
        user2.setName("天天");
        user2.setPass("1234456");
        list.add(user2);
        return list;
    }*/

    /**
     * @Valid 参数前面添加 @Valid 注解，代表此对象使用了参数校验；
     * BindingResult 参数校验的结果会存储在此对象中，
     * 可以根据属性判断是否校验通过，校验不通过可以将错误信息打印出来
     * */
    @RequestMapping(name = "/saveUser")
    public String saveUser(@Valid User user, BindingResult result){
        System.out.println("user:"+user);
        System.out.println(properties.getDescription());
        System.out.println(properties.getTitle());
        System.out.println(title);
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error: list) {
                System.out.println(error.getCode()+"-"+error.getDefaultMessage());
            }
            return "当前传入信息有误,请重新请求";
        }
        return new Gson().toJson(user);
    }
}
