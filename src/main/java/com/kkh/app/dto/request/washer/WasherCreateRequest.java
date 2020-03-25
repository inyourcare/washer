package com.kkh.app.dto.request.washer;

import lombok.Data;

@Data
public class WasherCreateRequest {
    int storeId;

    // 세탁기(W) / 건조기(D)
    private String role;

    // 대형(L) / 중형(M) / 특대형(E) / 초대형(U)
    private String capacity;

    private String washerName;
}
