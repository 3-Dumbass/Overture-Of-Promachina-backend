package com.oops.OvertureOfPromachina.common.gamePlayHandler;

import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.GameJoinDto;
import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.GameLeaveDto;
import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.GameMakeDto;

public interface GamePlayHandler {

    /**
     * 요청 하는 방에 대해 게임을 시작함
     * @param gameMakeDto 시작할 게임에 대한 정보
     */
    void makeGame(GameMakeDto gameMakeDto);

    /**
     * 해당 방에 가입함
     * @param gameJoinDto
     */
    void joinGame(GameJoinDto gameJoinDto);

    /**
     * 해당 게임에서 나감
     * @param gameLeaveDto 나가는 사람에 대한 정보
     */
    void leaveGame(GameLeaveDto gameLeaveDto);

    /**
     * 다음턴으로 이동
     * @param roomId 턴을 넘길 방 아이디
     */
    void nextTurn(Long roomId);

    /**
     * 모든 사람이 이번 턴을 마무리 했을 경우 다음으로 이동
     * @param roomId 턴을 넘길 방 아이디
     */
    void nextTurnIfFinishAllPlayer(Long roomId);

    /**
     * 이 게임을 종료
     * @param roomId 종료시킬 게임방을 종료
     */
    void finish(Long roomId);
}
