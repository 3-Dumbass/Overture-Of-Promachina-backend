package com.oops.OvertureOfPromachina.application.service.business.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import com.oops.OvertureOfPromachina.application.entity.gameRoomParticipant.GameRoomParticipant;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.gameRoom.GameRoomRepository;
import com.oops.OvertureOfPromachina.application.repository.gameRoomParticipant.GameRoomParticipantRepository;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.GameRoomRealTimeResponse;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.data.GameRoomJoinData;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.type.MessageType;
import com.oops.OvertureOfPromachina.application.service.domain.gameRoom.GameRoomDomainLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GameRoomServiceImpl implements GameRoomService{

    private final GameRoomDomainLogic gameRoomDomainLogic;
    private final GameRoomRepository gameRoomRepository;
    private final GameRoomParticipantRepository gameRoomParticipantRepository;

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
    public GameRoomRealTimeResponse<GameRoomJoinData> joinToGameRoom(GameRoom gameRoom, User user) {
        GameRoomParticipant gameRoomParticipant = new GameRoomParticipant(gameRoom, user);
        gameRoomParticipantRepository.save(gameRoomParticipant);
        return new GameRoomRealTimeResponse<>(
                MessageType.JOIN,
                new GameRoomJoinData(
                        user.getNickname().getNickname()
                )
        );
    }

    @Override
    public void leaveGameRoom(User user) {

    }


}
