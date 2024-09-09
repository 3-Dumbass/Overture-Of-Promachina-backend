package com.oops.OvertureOfPromachina.application.service.business.gameRoomService;

import com.oops.OvertureOfPromachina.application.entity.user.User;

public interface GameRoomService {

    /**
     * 유저가 게임룸을 제작해서 입장
     * @param user 게임룸을 제작하고자 하는 유저
     * @return 제작된 게임룸 id
     */
    Long makeRoom(User user);
}
