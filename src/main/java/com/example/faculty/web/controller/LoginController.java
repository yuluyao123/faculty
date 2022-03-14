package com.example.faculty.web.controller;

import com.example.faculty.service.UserInfoService;
import com.example.faculty.service.model.UserInfo;
import com.example.faculty.util.model.WebResult;
import com.example.faculty.web.model.UserInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/login")
    public WebResult login(@RequestBody UserInfoRequest userInfo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(Objects.isNull(userInfo.getUserName()) || Objects.isNull(userInfo.getPassword())){
            return WebResult.success("账户和密码不正确，请重新输入！");
        }
        WebResult<UserInfo> result = userInfoService.queryByUserAndPwd(userInfo.getUserName(), userInfo.getPassword());
        if (Objects.isNull(result)) {
            return WebResult.success("登录失败");
        }

        UserInfo user = result.getResult();
        session.setAttribute("USER", user);
        return WebResult.success(user);
    }
}
