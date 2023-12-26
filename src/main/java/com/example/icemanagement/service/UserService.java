package com.example.icemanagement.service;

import com.example.icemanagement.pojo.dto.UserLoginDTO;
import com.example.icemanagement.pojo.dto.UserRegisterDTO;
import com.example.icemanagement.pojo.dto.UserUpdateDTO;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.pojo.vo.UserVO;

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

    /**
     * 根据id获取前台展示数据
     * @param id
     * @return
     */
    UserVO getPersonById(Long id);

    /**
     *x修改个人信息
     * @param
     */
    void update(UserUpdateDTO userUpdateDTO);
}
