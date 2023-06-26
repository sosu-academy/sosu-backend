package com.academy.sosu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    DB_INSERT_ERROR("DB Insert Error", HttpStatus.CONFLICT),
    DB_SELECT_NO_RESULT("DB Select No Result", HttpStatus.INTERNAL_SERVER_ERROR),
    DB_SELECT_ERROR("DB Select Error", HttpStatus.INTERNAL_SERVER_ERROR),
    DB_UPDATE_ERROR("DB Update Error", HttpStatus.INTERNAL_SERVER_ERROR),
    DB_DELETE_ERROR("DB Delete Error", HttpStatus.INTERNAL_SERVER_ERROR),
        ;

    private final String errorString;
    private final HttpStatus httpStatus;

    ErrorCode(String errorString, HttpStatus httpStatus) {
        this.errorString = errorString;
        this.httpStatus = httpStatus;
    }
}
