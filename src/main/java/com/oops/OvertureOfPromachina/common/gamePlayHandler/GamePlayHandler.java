package com.oops.OvertureOfPromachina.common.gamePlayHandler;

import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.BettingDto;
import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.GameStartDto;

import java.util.List;

public interface GamePlayHandler {

    /**
     * 요청 하는 방에 대해 게임을 시작함
     * @param gameStartDto 시작할 게임에 대한 정보
     */
    void startGame(GameStartDto gameStartDto);

    /**
     * 유저가 배팅
     * @param bettingDto 배팅에 관한 정보
     * @return 첫번째 배팅일 경우 true 아닐 경우 false
     */
    Boolean betting(BettingDto bettingDto);


    /**
     * 모든 유저가 배팅을 했는지 확인
     * @return 모든 유저가 배팅을 마쳤는지 확인
     */
    Boolean checkAllPeopleBetting();
}
