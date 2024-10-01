package com.oops.OvertureOfPromachina.application.repository.gameRoomParticipant;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.gameRoomParticipant.GameRoomParticipant;
import com.oops.OvertureOfPromachina.application.entity.user.User;

import java.util.List;

public interface GameRoomParticipantRepository {

    Long save(GameRoomParticipant gameRoomParticipant);

    /**
     * 해당 유저가 포함된 정보 삭제
     * @param user 삭제할 유저
     */
    void removeByUser(User user);

    /**
     * 해당 유저가 참가 중인 게임룸 찾기
     * @param user 확인하고자 하는 유저 객체
     * @return 참가중인 게임룸이 있을 경우 게임룸, 없을 경우 null
     */
    GameRoom findByUser(User user);

    /**
     * 해당 게임룸 안에 입장해 있는 참가 정보를 가져옴
     * @param roomId 게임룸 아이디
     * @return 해당 게임룸에 포함된 참가정보
     */
    List<User> findAllUserByRoomId(Long roomId);
}
