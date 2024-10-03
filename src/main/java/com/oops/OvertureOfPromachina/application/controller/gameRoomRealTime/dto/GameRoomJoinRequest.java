package com.oops.OvertureOfPromachina.application.controller.gameRoomRealTime.dto;

import com.oops.OvertureOfPromachina.application.controller.user.dto.UserDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class GameRoomJoinRequest {
    @NotNull
    private UserDto userInfo;
    @NotNull
    private Long roomId;
}
