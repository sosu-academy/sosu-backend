package com.academy.sosu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    DB_INSERT_ERROR("DB Insert Error", HttpStatus.CONFLICT),
        ;

    private final String errorString;
    private final HttpStatus httpStatus;

    ErrorCode(String errorString, HttpStatus httpStatus) {
        this.errorString = errorString;
        this.httpStatus = httpStatus;
    }
}
