package com.academy.sosu.exception;

public class SearchDatabaseException extends Exception {

    public SearchDatabaseException(ErrorCode errorCode) {
        super(errorCode.getErrorString());
    }
}
