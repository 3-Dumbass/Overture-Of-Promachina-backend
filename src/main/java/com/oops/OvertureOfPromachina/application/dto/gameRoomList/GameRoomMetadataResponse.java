package com.oops.OvertureOfPromachina.application.dto.gameRoomList;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
@AllArgsConstructor
public class GameRoomMetadataResponse {
    private Long gameRoomId;
    private GameModeEnum gameMode;
    private LocalDateTime createTime;
}
