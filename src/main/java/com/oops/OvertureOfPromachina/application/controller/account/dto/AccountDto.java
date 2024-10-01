package com.oops.OvertureOfPromachina.application.controller.account.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountDto {
    private Long user_id;
    private String accountKey;
    private String priKey;
}
