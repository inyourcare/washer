package com.kkh.app.code.washer;

public enum WasherCapacityCode {
    MEDIUM("M", "중형"),
    LARGE("L", "대형"),
    EXTRA_LARGE("E", "특대형"),
    ;
    private String code;
    private String message;

    private WasherCapacityCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
