package com.example.faculty.service.impl;

import com.example.faculty.mapper.UserInfoMapper;
import com.example.faculty.mapper.model.UserInfoDO;
import com.example.faculty.service.UserInfoService;
import com.example.faculty.service.model.UserInfo;
import com.example.faculty.util.model.WebResult;
import com.example.faculty.web.model.UserInfoRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public WebResult<Long> insert(UserInfoRequest request) {
        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(request, userInfoDO);
        return WebResult.success(userInfoMapper.insert(userInfoDO));
    }

    @Override
    public WebResult<Integer> update(UserInfoRequest request) {
        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(request, userInfoDO);

        return WebResult.success(userInfoMapper.update(userInfoDO));
    }

    @Override
    public WebResult<UserInfo> query(Long id) {
        return WebResult.success(userInfoMapper.query(id));
    }

    @Override
    public WebResult<List<UserInfo>> queryList(UserInfoRequest request) {
        return WebResult.success(userInfoMapper.queryList(request));
    }

    @Override
    public WebResult<Integer> delete(Long id) {
        return WebResult.success(userInfoMapper.delete(id));
    }
}
