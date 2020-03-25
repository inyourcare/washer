package com.kkh.app.exception.message;

import lombok.Getter;

@Getter
public enum AuthExceptionMessage {

    PHONE_NO_REGEX_ERROR("Phone number regex error"),
    EMAIL_REGEX_ERROR("email regex error"),
    USER_NAME_REGEX_ERROR("name regex error"),
    ;
    final private String message;

    AuthExceptionMessage(String message) {
        this.message = message;
    }
}
