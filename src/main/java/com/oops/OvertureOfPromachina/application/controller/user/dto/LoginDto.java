package com.oops.OvertureOfPromachina.application.controller.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginDto {

    private String login_id;
    private String password;


    public LoginDto(String login_id, String password) {
        this.login_id = login_id;
        this.password = password;
    }
}
