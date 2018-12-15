package com.zxs.mine.api.exception;

public class UserLoginInvalidException extends  Exception {

    public UserLoginInvalidException(String message) {
        super(message);
    }

    public UserLoginInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginInvalidException(Throwable cause) {
        super(cause);
    }
}
