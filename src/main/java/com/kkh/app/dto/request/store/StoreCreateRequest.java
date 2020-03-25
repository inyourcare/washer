package com.kkh.app.dto.request.store;

import lombok.Data;

@Data
public class StoreCreateRequest {

    // 지점 명
    private String storeName;
    // 직영(D) / 가맹(J)
    private String contractType;

}
