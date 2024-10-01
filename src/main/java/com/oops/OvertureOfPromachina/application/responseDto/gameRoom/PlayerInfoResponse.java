package com.oops.OvertureOfPromachina.application.responseDto.gameRoom;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayerInfoResponse {
    private Long userId;

    private String nickname;

    private Long money;
}
