package com.example.faculty.web.controller;

import com.example.faculty.service.UserInfoService;
import com.example.faculty.service.model.UserInfo;
import com.example.faculty.util.model.WebResult;
import com.example.faculty.web.model.UserInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/login")
    public WebResult login(UserInfoRequest userInfo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Assert.notNull(userInfo.getUserName(), "账号不能为空！");
        Assert.notNull(userInfo.getPassword(), "密码不能为空！");
        WebResult<UserInfo> result = userInfoService.queryByUserAndPwd(userInfo.getUserName(), userInfo.getPassword());
        if (Objects.isNull(result)) {
            return WebResult.success("登录失败");
        }

        UserInfo user = result.getData();
        session.setAttribute("USER", user);
        return WebResult.success(user);
    }

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
