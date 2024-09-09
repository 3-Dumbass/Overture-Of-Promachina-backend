package com.oops.OvertureOfPromachina.application.service.business.gameRoomListService;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;

import java.util.List;

interface GameRoomListService {
    /**
     * 게임룸 리스트 가져오기
     * @param page 몇 번째 페이지인지(0부터 시작)
     * @param size 한 페이지에 몇개씩 들어가게 할 것인지
     * @return 요청에 맞는 게임룸 리스트
     */
    List<GameRoom> getGameRoomList(Long page, Long size);
}
