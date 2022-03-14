package com.example.faculty.web.model;

import com.example.faculty.util.model.PageDTO;
import lombok.Data;

@Data
public class UserInfoRequest extends PageDTO {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户类型
     * app_user:app用户、program_user:程序用户、system_user:系统用户
     */
    private String type;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private Long phoneNumber;

    /**
     * 归属学校
     */
    private String school;

    /**
     * 职务
     */
    private String duties;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     * enable:启动、disable:禁用
     */
    private Boolean status;

}
