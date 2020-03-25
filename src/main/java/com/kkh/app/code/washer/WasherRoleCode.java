package com.kkh.app.code.washer;

public enum WasherRoleCode {
    WASHER("W", "세탁기"),
    DRYER("D", "건조기"),
    ;
    private String code;
    private String message;

    private WasherRoleCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
