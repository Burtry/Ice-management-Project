package com.example.icemanagement.service;

import com.example.icemanagement.pojo.dto.UserLoginDTO;
import com.example.icemanagement.pojo.dto.UserRegisterDTO;
import com.example.icemanagement.pojo.entity.User;

public interface UserService {

    User findById(Long id);



    /**
     * 用户注册
     * @param userRegisterDTO
     */
    void userRegister(UserRegisterDTO userRegisterDTO);

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    User userLogin(UserLoginDTO userLoginDTO);
}
