package com.oops.OvertureOfPromachina.application.repository.gameRoomList;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;

import java.util.List;

public interface GameRoomListRepository {

    /**
     * 게임룸 목록 반환
     * @param page 몇 번째 페이지 인지
     * @param size 페이지에 들어가는 게임룸 수
     * @return 현재 페이지에 해당되는 게임룸
     */
    List<GameRoom> getGameRoomList(Long page, Long size);

    /**
     * 모든 게임룸의 개수를 반환
     * @return 모든 게임룸 개수
     */
    Long getAllGameRoomAmount();
}
