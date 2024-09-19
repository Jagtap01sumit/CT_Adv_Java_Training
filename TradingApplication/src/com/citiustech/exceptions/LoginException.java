package com.citiustech.exceptions;
public class LoginException extends RuntimeException {
    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}