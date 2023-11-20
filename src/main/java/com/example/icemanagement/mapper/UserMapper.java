package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    User findById(Integer id);
}
