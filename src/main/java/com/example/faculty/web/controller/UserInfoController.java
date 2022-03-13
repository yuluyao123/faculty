package com.example.faculty.web.controller;

import com.example.faculty.service.UserInfoService;
import com.example.faculty.util.model.WebResult;
import com.example.faculty.web.model.UserInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/add")
    public WebResult add(UserInfoRequest request){
        return userInfoService.insert(request);
    }

    @RequestMapping("/update")
    public WebResult update(UserInfoRequest request){
        return userInfoService.update(request);
    }

    @RequestMapping("/query")
    public WebResult query(UserInfoRequest request){
        return userInfoService.query(request.getId());
    }

    @RequestMapping("/queryList")
    public WebResult queryList(UserInfoRequest request){
        return userInfoService.queryList(request);
    }

}
