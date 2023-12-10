package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.entity.Admin;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminMapper {
    /**
     * 根据用户名进行查询
     * @param username
     * @return
     */
    @Select("select * from icemanagement.employee where user_name = #{username}")
    Admin getByUsername(String username);

    /**
     * 新增admin
     * @param admin
     */
    @Insert("insert into icemanagement.employee(user_name, password, create_time, name, id_number, phone, sex, update_time) values(#{username},#{password},#{createTime},#{name},#{idNumber},#{phone},#{sex},#{updateTime})")
    void insert(Admin admin);

    /**
     * 删除管理员
     * @param id
     */
    @Delete("delete from icemanagement.employee where id = #{id}")
    void delete(Long id);

    /**
     * 根据id查询管理员
     * @param id
     * @return
     */
    @Select("select * from icemanagement.employee where id = #{id}")
    Admin findById(Long id);

    /**
     * 修改管理员信息
     * @param admin
     */
    void update(Admin admin);

    /**
     * 根基用户名查找用户
     * @param username
     * @return
     */
    @Select("select * from icemanagement.employee where user_name = #{username}")
    Admin findByUserName(String username);
}
