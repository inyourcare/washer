package com.kkh.app.code.store;

import lombok.Getter;

@Getter
public enum StoreContractTypeCode {
    DIRECT("D", "직영"),
    JOIN("J", "가맹"),
    ;
    private String code;
    private String message;

    private StoreContractTypeCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
