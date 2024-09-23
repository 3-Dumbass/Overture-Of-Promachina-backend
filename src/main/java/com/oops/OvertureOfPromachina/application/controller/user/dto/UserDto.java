package com.oops.OvertureOfPromachina.application.controller.user.dto;

import com.oops.OvertureOfPromachina.application.entity.account.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

    private long id;
    private List<Account> account;

    public UserDto(long id, List<Account> account) {
        this.id = id;
        this.account = account;
    }
}
