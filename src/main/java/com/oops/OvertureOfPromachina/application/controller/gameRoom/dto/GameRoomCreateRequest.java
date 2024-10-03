package com.oops.OvertureOfPromachina.application.controller.gameRoom.dto;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class GameRoomCreateRequest {
    @NotBlank
    private String roomName;
    @NotNull
    private String gameMode;
}
