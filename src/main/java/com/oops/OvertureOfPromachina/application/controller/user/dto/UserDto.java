package com.oops.OvertureOfPromachina.application.controller.user.dto;

import com.oops.OvertureOfPromachina.application.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

    private long id;
    private String account;
    private String priKey;

    public UserDto(long id, String account, String priKey) {
        this.id = id;
        this.account = account;
        this.priKey = priKey;
    }
}
