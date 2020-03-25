package com.kkh.app.dto.request.store;

import lombok.Getter;

@Getter
public class StoreUpdateRequest {
    // 지점 명
    private int storeId;
    // 지점 명
    private String storeName;
    // 직영(D) / 가맹(J)
    private String contractType;
}
