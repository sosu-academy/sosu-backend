package com.academy.sosu.exception;

public class InsertDatabaseException extends IllegalArgumentException {

    public InsertDatabaseException() {
        super();
    }

    public InsertDatabaseException(String s) {
        super(s);
    }

    public InsertDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertDatabaseException(Throwable cause) {
        super(cause);
    }
}
