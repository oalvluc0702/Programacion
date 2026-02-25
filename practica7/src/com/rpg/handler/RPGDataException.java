package com.rpg.handler;

public class RPGDataException extends Exception {
    public RPGDataException() {
    }

    public RPGDataException(String message) {
        super(message);
    }

    public RPGDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public RPGDataException(Throwable cause) {
        super(cause);
    }

    public RPGDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
