package com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.data;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameRoomJoinData {
    private Long userId;

    private String nickname;

    private Long money;
}
