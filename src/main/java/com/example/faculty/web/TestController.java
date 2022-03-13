package com.example.faculty.web;

import com.example.faculty.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/hello")
    public  String  login(){
        return "hello world!!";
    }

}
