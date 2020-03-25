package com.kkh.app.dto.request.washer;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class WasherSetAvailableRequest {

    public List<WasherAvailableInfo> washerAvailableInfoList;

    @Data
    public static class WasherAvailableInfo{
        int storeId;
        int washerId;
        Boolean isAvailable;
    }
}
