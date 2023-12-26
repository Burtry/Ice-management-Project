package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.entity.Admin;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.pojo.vo.UserVO;
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


    /**
     * 根据id获取前台展示数据
     * @param id
     * @return
     */
    @Select("select user_name,name,sex,id_number,phone from icemanagement.user where id = #{id}")
    UserVO getUserVOById(Long id);


    @Select("select * from icemanagement.user where id = #{id}")
    User getById(Long id);

    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);
}
