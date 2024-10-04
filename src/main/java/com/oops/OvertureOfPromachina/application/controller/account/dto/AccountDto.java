package com.oops.OvertureOfPromachina.application.controller.account.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccountDto {
    private Long user_id;
    private String accountKey;
    private String priKey;
}
