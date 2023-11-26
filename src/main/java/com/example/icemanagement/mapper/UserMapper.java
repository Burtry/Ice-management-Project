package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    User findById(Integer id);

    /**
     * 通过账号和密码查询用户
     * @param userAccount
     * @param userPassword
     */
    @Select("select * from icemanagement.user where account = #{userAccount} and password = #{userPassword}")
    User getByAccountAndPassword(String userAccount, String userPassword);

    /**
     * 创建新用户
     * @param newUSer
     */

    @Insert("insert into icemanagement.user (create_time, account, password, user_name, sex, phone, id_number, update_time)" +
            " VALUES (#{createTime},#{account},#{password},#{userName},#{sex},#{phone},#{idNumber},#{updateTime})")
    void register(User newUSer);
}
