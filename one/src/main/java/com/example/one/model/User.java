package com.example.one.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class User {
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @Max(value=100,message = "年龄不能大于100")
    @Min(value = 18,message = "年龄不能小于18")
    private Integer age;
    @Length(min = 6,message = "密码不能小于6位数") //message中的值为制自定义的报错信息
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
