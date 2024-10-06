package com.oops.OvertureOfPromachina.application.controller.gameRoom.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class RoomInfoRequest {
    @NotNull
    private Long roomId;
}
