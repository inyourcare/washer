package com.kkh.app.dto.request;

import lombok.Data;

@Data
public class SignUpRequest {
    String loginId;
    String password;

    String name;
    String email;
    String phoneNo;
}
