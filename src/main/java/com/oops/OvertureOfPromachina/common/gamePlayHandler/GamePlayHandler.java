package com.oops.OvertureOfPromachina.common.gamePlayHandler;

import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.GameStartDto;

import java.util.List;

public interface GamePlayHandler {

    /**
     * 요청 하는 방에 대해 게임을 시작함
     * @param gameStartDto 시작할 게임에 대한 정보
     */
    void startGame(GameStartDto gameStartDto);
}
