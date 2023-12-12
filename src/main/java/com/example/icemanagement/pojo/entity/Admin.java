package com.example.icemanagement.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 管理员
 */
@Data
public class Admin implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;

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
    /**
     *更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}

