package com.oops.OvertureOfPromachina.common.gamePlayHandler.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BettingDto {
    private final Long roomId;
    private final Long userId;
}
