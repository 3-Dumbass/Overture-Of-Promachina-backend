package com.oops.OvertureOfPromachina.application.controller.gameRoomRealTime.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class GameRoomJoinRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long roomId;
}
