package com.example.faculty.mapper;

import com.example.faculty.mapper.model.UserInfoDO;
import com.example.faculty.web.model.UserInfoRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    String columns = "id, "
            + "gmt_create as gmtCreate, "
            + "gmt_modify as gmtModify, "
            + "type, "
            + "user_name as userName, "
            + "real_name as realName, "
            + "phone_number as phoneNumber, "
            + "school, "
            + "duties, "
            + "password, "
            + "status";

    @Insert({"insert into sys_role(id, gmt_create, gmt_modify, type, user_name, realName, phone_number, school, duties, password, status) " +
            "values (now(), now(), #{type}, #{userName), #{realName), #{phoneNumber), #{school), #{duties), #{password), #{status)"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = Long.class, before = false)
    Long insert(UserInfoDO userInfoDO);

    @Update("<script>" +
            "UPDATE user_info  " +
            "<set>" +
            "   gmt_modify = now()," +
            "   <if test='userName != null and userName != \"\"'> user_name = #{userName}, </if>" +
            "   <if test='realName != null and realName != \"\"'> real_name = #{realName}, </if>" +
            "   <if test='phoneNumber != null and phoneNumber != \"\"'> phone_number = #{phoneNumber}, </if>" +
            "   <if test='school != null and school != \"\"'> school = #{school}, </if>" +
            "   <if test='duties != null and duties != \"\"'> duties = #{duties}, </if>" +
            "   <if test='password != null and password != \"\"'> password = #{password}, </if>" +
            "   <if test='status != null and status != \"\"'> status = #{status}, </if>" +
            "</set>" +
            " where id = #{id}" +
            "</script>")
    int update(UserInfoDO userInfoDO);

    @Select("select " + columns + " from user_info where id  = #{id}")
    UserInfoDO queryById(Long id);

    @Select("select " + columns + " from user_info where user_name  = #{userName} and password  = #{password}")
    UserInfoDO queryByUserAndPwd(@Param("userName")String userName, @Param("password")String password);

    @Select("<script>" +
            "select * from sys_user_tab " +
            "<where>" +
            "   <if test='userName != null and userName != \"\"'> user_name like CONCAT('%', #{name}, '%'), </if>" +
            "</where>" +
            "limit #{beginRow}, #{endRow} " +
            "</script>")
    List<UserInfoDO> queryList(UserInfoRequest request);

    @Delete("DELETE FROM user_info where id  = #{id}")
    int delete(Long id);


}
