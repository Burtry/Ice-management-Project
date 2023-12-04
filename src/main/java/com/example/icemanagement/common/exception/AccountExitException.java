package com.example.icemanagement.common.exception;

/**
 * 账号存在异常
 */
public class AccountExitException extends RuntimeException{
    public AccountExitException() {
    }

    public AccountExitException(String message) {
        super(message);
    }
}
