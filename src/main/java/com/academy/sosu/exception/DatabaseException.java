package com.academy.sosu.exception;

public class DatabaseException extends Exception {

    public DatabaseException(ErrorCode errorCode) {
        super(errorCode.getErrorString());
    }
}
