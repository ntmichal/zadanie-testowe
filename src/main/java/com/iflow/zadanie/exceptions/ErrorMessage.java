package com.iflow.zadanie.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    private int code;
    private HttpStatus status;
    private String message;

    public ErrorMessage(HttpStatus status, String message) {
        this.code = status.value();
        this.status = status;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
