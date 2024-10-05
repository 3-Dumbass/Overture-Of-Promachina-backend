package com.oops.OvertureOfPromachina.common.gamePlayHandler.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class GameJoinDto {
    private final Long roomId;
    private final Long userId;
}
