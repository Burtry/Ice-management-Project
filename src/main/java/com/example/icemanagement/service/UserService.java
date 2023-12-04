package com.example.icemanagement.service;

import com.example.icemanagement.pojo.dto.UserRegisterDTO;
import com.example.icemanagement.pojo.entity.User;

public interface UserService {

    User findById(Long id);

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @return
     */
    User userLogin(String userAccount, String userPassword);

    /**
     * 用户注册
     * @param userRegisterDTO
     */
    void userRegister(UserRegisterDTO userRegisterDTO);
}
