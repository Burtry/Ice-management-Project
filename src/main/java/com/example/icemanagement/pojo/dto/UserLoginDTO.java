package com.example.icemanagement.pojo.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserLoginDTO implements Serializable {

    private String userAccount;

    private String userPassword;
}
