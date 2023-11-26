package com.example.icemanagement.common.exception;

/**
 * 密码错误异常
 */
public class PasswordErrorException extends RuntimeException {

    public PasswordErrorException() {
    }

    public PasswordErrorException(String msg) {
        super(msg);
    }

}
