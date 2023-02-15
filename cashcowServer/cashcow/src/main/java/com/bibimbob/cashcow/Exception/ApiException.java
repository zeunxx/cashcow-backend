package com.bibimbob.cashcow.Exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private ExceptionEnum error;

    public ApiException(String message, ExceptionEnum error) {
        super(message);
        this.error = error;
    }
}
