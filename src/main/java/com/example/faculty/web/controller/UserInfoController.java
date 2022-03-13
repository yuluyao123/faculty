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

    @RequestMapping("/add.json")
    public WebResult add(@RequestBody UserInfoRequest request){
        return userInfoService.insert(request);
    }

    @RequestMapping("/update.json")
    public WebResult update(@RequestBody UserInfoRequest request){
        return userInfoService.update(request);
    }

    @RequestMapping("/query.json")
    public WebResult query(@RequestBody UserInfoRequest request){
        return userInfoService.queryById(request.getId());
    }

    @RequestMapping("/queryList.json")
    public WebResult queryList(@RequestBody UserInfoRequest request){
        return userInfoService.queryList(request);
    }

    @RequestMapping("/delete.json")
    public WebResult delete(@RequestBody UserInfoRequest request){
        return userInfoService.delete(request.getId());
    }

}
