package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.entity.Admin;
import com.example.icemanagement.pojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 通过账号查询用户
     */
    @Select("select * from icemanagement.user where user_name = #{userName}")
    User getByUsername(String userName);

    /**
     * 创建新用户
     * @param newUser
     */
    @Insert("insert into icemanagement.user(user_name, password, create_time, name, id_number, phone, sex, update_time) values " +
            "(#{userName},#{password},#{createTime},#{name},#{idNumber},#{phone},#{sex},#{updateTime})")
    void register(User newUser);



}
