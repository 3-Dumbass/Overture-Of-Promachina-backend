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
    public Long makeRoom(GameModeEnum gameMode) {
        GameRoom gameRoom = gameRoomDomainLogic.makeGameRoom(gameMode);
        gameRoomRepository.save(gameRoom);
        return gameRoom.getId();
    }

    @Override
    public GameRoom findGameRoomById(Long id) {
        return gameRoomRepository.findById(id);
    }

    @Override
    public Long joinToGameRoom(GameRoom gameRoom, User user) {
        return null;
    }

    @Override
    public void leaveGameRoom(User user) {

    }


}
