package com.academy.sosu.exception;

public class InsertDatabaseException extends Exception {

    public InsertDatabaseException(ErrorCode errorCode) {
        super(errorCode.getErrorString());
    }
}
