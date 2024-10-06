package com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameRoomLeaveData {
    private Long userId;
}
