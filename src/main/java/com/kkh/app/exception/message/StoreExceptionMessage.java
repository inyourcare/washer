package com.kkh.app.exception.message;

import lombok.Getter;

@Getter
public enum StoreExceptionMessage {
    STORE_NOT_FOUND("Store not found"),
    ;
    final private String message;

    StoreExceptionMessage(String message) {
        this.message = message;
    }
}
