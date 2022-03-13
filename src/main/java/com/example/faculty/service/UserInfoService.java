package com.example.faculty.service;

import com.example.faculty.service.model.UserInfo;
import com.example.faculty.util.model.WebResult;
import com.example.faculty.web.model.UserInfoRequest;

import java.util.List;

public interface UserInfoService {

    /**
     * 新增用户
     * @param request
     * @return
     */
    WebResult<Long> insert(UserInfoRequest request);

    /**
     * 修改用户
     * @param request
     * @return
     */
    WebResult<Integer> update(UserInfoRequest request);

    /**
     * 查询用户
     * @param id
     * @return
     */
    WebResult<UserInfo> queryById(Long id);

    /**
     * 登录验证
     * @param userName
     * @param password
     * @return
     */
    WebResult<UserInfo> queryByUserAndPwd(String userName, String password);

    /**
     * 查询用户列表
     * @param request
     * @return
     */
    WebResult<List<UserInfo>> queryList(UserInfoRequest request);

    /**
     * 删除用户
     * @param id
     * @return
     */
    WebResult<Integer> delete(Long id);

}
