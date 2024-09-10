package com.oops.OvertureOfPromachina.application.service.business.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.gameRoom.GameRoomRepository;
import com.oops.OvertureOfPromachina.application.service.domain.gameRoom.GameRoomDomainLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GameRoomServiceImpl implements GameRoomService{

    private final GameRoomDomainLogic gameRoomDomainLogic;
    private final GameRoomRepository gameRoomRepository;

    @Override
    public Long makeRoom(User user, GameModeEnum gameMode) {
        GameRoom gameRoom = gameRoomDomainLogic.makeGameRoom(gameMode);
        gameRoomRepository.save(gameRoom);
        //TODO: 제작한 유저가 해당 룸에 입장하는 부분 추가
        return gameRoom.getId();
    }

    @Override
    public Long joinToGameRoom(GameRoom gameRoom, User user) {
        return null;
    }

    @Override
    public void leaveGameRoom(User user) {

    }


}
