package com.example.icemanagement.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String userName;

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
    /**
     *更新时间
     */
    private LocalDateTime updateTime;
}

