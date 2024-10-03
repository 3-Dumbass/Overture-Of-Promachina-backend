package com.oops.OvertureOfPromachina.application.service.business.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import com.oops.OvertureOfPromachina.application.entity.gameRoomParticipant.GameRoomParticipant;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.application.repository.gameRoom.GameRoomRepository;
import com.oops.OvertureOfPromachina.application.repository.gameRoomParticipant.GameRoomParticipantRepository;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoom.GameRoomInfoResponse;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.GameRoomRealTimeResponse;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.data.GameRoomJoinData;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.type.MessageType;
import com.oops.OvertureOfPromachina.application.service.domain.gameRoom.GameRoomDomainLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
class GameRoomServiceImpl implements GameRoomService{

    private final GameRoomDomainLogic gameRoomDomainLogic;
    private final GameRoomRepository gameRoomRepository;
    private final GameRoomParticipantRepository gameRoomParticipantRepository;
    private final UserRepository userRepository;

    @Override
    public Long makeRoom(String title,String  gameMode) {
        GameModeEnum gameModeEnum = GameModeEnum.valueOf(gameMode);
        GameRoom gameRoom = gameRoomDomainLogic.makeGameRoom(title, gameModeEnum);
        gameRoomRepository.save(gameRoom);
        return gameRoom.getId();
    }

    @Override
    public GameRoom findGameRoomById(Long id) {
        return gameRoomRepository.findById(id);
    }

    @Override
    public GameRoomRealTimeResponse<GameRoomJoinData> joinToGameRoom(Long gameRoomId,Long userId) {
        User user = null;
        GameRoom gameRoom = gameRoomRepository.findById(gameRoomId);

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

    @Override
    public GameRoomInfoResponse getGameRoomInfo(Long roomId) {
        List<User> users = gameRoomParticipantRepository.findAllUserByRoomId(roomId);
        GameRoomInfoResponse gameRoomInfoResponse = new GameRoomInfoResponse(users);
        return gameRoomInfoResponse;
    }


}
