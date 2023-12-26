package com.example.icemanagement.pojo.dto;

import lombok.Data;

@Data
public class UserUpdateDTO {

    //用户id
    private Long id;
    /**
     * 密码
     */
    private String password;
    /**
     * 确认密码
     */
    private String passwordAgain;
    /**
     * 用户昵称
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话
     */
    private String phone;
    /**
     * 身份证
     */
    private String idNumber;

}
