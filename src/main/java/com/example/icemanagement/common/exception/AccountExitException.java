package com.example.icemanagement.common.exception;

public class AccountExitException extends RuntimeException{
    public AccountExitException() {
    }

    public AccountExitException(String message) {
        super(message);
    }
}
