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

    private Long user_id;
    private String nickname;
    private String image_url;
    private List<Account> account;

    public UserDto(Long user_id, String nickname, String image_url, List<Account> account) {
        this.user_id = user_id;
        this.nickname = nickname;
        this.image_url = image_url;
        this.account = account;
    }
}
