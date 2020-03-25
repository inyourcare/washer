package com.kkh.app.dto.request;

import lombok.Data;

@Data
public class SignInRequest {
    private static final long serialVersionUID = 5926468583005150707L;

    private String loginId;
    private String password;
}
