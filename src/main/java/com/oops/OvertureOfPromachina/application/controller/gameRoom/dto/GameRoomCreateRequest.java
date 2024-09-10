package com.oops.OvertureOfPromachina.application.controller.gameRoom.dto;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class GameRoomCreateRequest {
    @NotNull
    private Long UserId;
    @NotNull
    private GameModeEnum gameMode;
}
