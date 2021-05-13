package com.reflexian.publicapi.exceptions;

@SuppressWarnings("unused")
public class ReflexianException extends RuntimeException {

    public ReflexianException() {
    }

    public ReflexianException(String message) {
        super(message);
    }

    public ReflexianException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflexianException(Throwable cause) {
        super(cause);
    }

    public ReflexianException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
