package com.kkh.app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ExpectableException extends RuntimeException {

    private static final long serialVersionUID = -1113582265865921787L;

    @Builder
    public ExpectableException(String message) {
        super(message);
    }

    //@Builder
    public ExpectableException(String message, Throwable cause) {
        super(message, cause);
    }
}