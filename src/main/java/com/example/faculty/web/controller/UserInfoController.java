package com.example.faculty.web.controller;

import com.example.faculty.service.UserInfoService;
import com.example.faculty.util.model.WebResult;
import com.example.faculty.web.model.UserInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/update")
    public WebResult update(@RequestBody UserInfoRequest request){
        return userInfoService.update(request);
    }

    @RequestMapping("/queryById")
    public WebResult queryById(@RequestBody UserInfoRequest request){
        return userInfoService.queryById(request.getId());
    }

    @RequestMapping("/queryList")
    public WebResult queryList(@RequestBody UserInfoRequest request){
        return userInfoService.queryList(request);
    }

    @RequestMapping("/delete")
    public WebResult delete(@RequestBody UserInfoRequest request){
        return userInfoService.delete(request.getId());
    }

}
