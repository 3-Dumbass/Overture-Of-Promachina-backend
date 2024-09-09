package com.oops.OvertureOfPromachina.application.service.business.gameRoomService;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import com.oops.OvertureOfPromachina.application.entity.user.User;

import java.util.List;

public interface GameRoomService {

    /**
     * 유저가 게임룸을 제작해서 입장
     * @param user 게임룸을 제작하고자 하는 유저
     * @return 제작된 게임룸 id
     */
    Long makeRoom(User user, GameModeEnum gameMode);


    /**
     * 게임룸 리스트 가져오기
     * @param page 몇 번째 페이지인지(0부터 시작)
     * @param size 한 페이지에 몇개씩 들어가게 할 것인지
     * @return 요청에 맞는 게임룸 리스트
     */
    List<GameRoom> getGameRoomList(Long page, Long size);

    /**
     * 유저가 게임룸에 입장
     * @param gameRoom 입장할 게임룸
     * @param user 입장할 유저
     * @return 입장된 게임룸의 id
     */
    Long joinToGameRoom(GameRoom gameRoom, User user);

    /**
     * 유저가 참가중인 게임방을 나감
     * @param user 나가고자 하는 유저
     */
    void leaveGameRoom(User user);
}
