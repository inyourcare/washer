package com.kkh.app.exception.message;

import lombok.Getter;

@Getter
public enum WasherExceptionMessage {
    WASHER_NOT_FOUND("Washer not found"),
    ;
    final private String message;

    WasherExceptionMessage(String message) {
        this.message = message;
    }
}
