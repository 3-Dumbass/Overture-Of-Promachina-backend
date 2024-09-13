package com.oops.OvertureOfPromachina.application.service.business.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import com.oops.OvertureOfPromachina.application.entity.user.User;

public interface GameRoomService {

    /**
     * 유저가 게임룸을 제작해서 입장
     * @param user 게임룸을 제작하고자 하는 유저
     * @return 제작된 게임룸 id
     */
    Long makeRoom(User user, GameModeEnum gameMode);

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
