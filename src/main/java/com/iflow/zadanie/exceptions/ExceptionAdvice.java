package com.iflow.zadanie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage sendArrayIsNull(NullPointerException exception){
        return new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage wrongDataFromat(HttpMessageNotReadableException exception){
        return new ErrorMessage(HttpStatus.BAD_REQUEST, "Wrong data format");
    }
    @ExceptionHandler(ArrayIsEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage sendArrayEmptyArray(ArrayIsEmptyException exception){
        return new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
    }


}
