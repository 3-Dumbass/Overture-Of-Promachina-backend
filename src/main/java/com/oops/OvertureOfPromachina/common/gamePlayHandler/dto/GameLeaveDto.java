package com.oops.OvertureOfPromachina.common.gamePlayHandler.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GameLeaveDto {
    private final Long roomId;
    private final Long userId;
}
