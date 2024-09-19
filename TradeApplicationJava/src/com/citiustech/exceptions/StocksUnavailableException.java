package com.citiustech.exceptions;

public class StocksUnavailableException extends RuntimeException {
    public StocksUnavailableException(String message) {
        super(message);
    }
}