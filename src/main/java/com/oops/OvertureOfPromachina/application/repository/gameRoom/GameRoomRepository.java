package com.oops.OvertureOfPromachina.application.repository.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.user.User;

public interface GameRoomRepository {

    /**
     * 게임 룸 저장
     * @param gameRoom 생성된 게임룸
     * @return 저장된 GameRoom의 id
     */
    Long save(GameRoom gameRoom);

    /**
     * 게임 룸 삭제
     * @param gameRoom 삭제할 게임룸
     */
    void remove(GameRoom gameRoom);

    /**
     * id로 게임 룸 검색
     * @param id 게임룸 id
     * @return 찾아진 게임룸
     */
    GameRoom findById(Long id);
}
