package com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime;

import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.type.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class GameRoomRealTimeResponse <T> {
    private MessageType messageType;
    private T data;
}
