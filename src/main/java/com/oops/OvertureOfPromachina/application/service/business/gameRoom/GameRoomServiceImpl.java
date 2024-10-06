package com.oops.OvertureOfPromachina.application.service.business.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import com.oops.OvertureOfPromachina.application.entity.casinoChip.CasinoChip;
import com.oops.OvertureOfPromachina.application.entity.gameRoomParticipant.GameRoomParticipant;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.CasinoChip.CasinoChipRepository;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.application.repository.gameRoom.GameRoomRepository;
import com.oops.OvertureOfPromachina.application.repository.gameRoomParticipant.GameRoomParticipantRepository;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoom.GameRoomInfoResponse;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.GameRoomRealTimeResponse;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.data.GameRoomJoinData;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.data.GameRoomLeaveData;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.type.MessageType;
import com.oops.OvertureOfPromachina.application.service.domain.gameRoom.GameRoomDomainLogic;
import com.oops.OvertureOfPromachina.common.gamePlayHandler.GamePlayHandler;
import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.GameJoinDto;
import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.GameMakeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
class GameRoomServiceImpl implements GameRoomService {

    private final GameRoomDomainLogic gameRoomDomainLogic;
    private final GameRoomRepository gameRoomRepository;
    private final GameRoomParticipantRepository gameRoomParticipantRepository;
    private final UserRepository userRepository;
    private final CasinoChipRepository casinoChipRepository;
    private final GamePlayHandler gamePlayHandler;

    @Override

    public Long makeRoom(String title, String gameMode) {
        GameModeEnum gameModeEnum = GameModeEnum.valueOf(gameMode);
        GameRoom gameRoom = gameRoomDomainLogic.makeGameRoom(title, gameModeEnum);
        gameRoomRepository.save(gameRoom);
        gamePlayHandler.makeGame(new GameMakeDto(
                gameRoom.getId()
        ));
        return gameRoom.getId();
    }

    @Override
    public GameRoom findGameRoomById(Long id) {
        return gameRoomRepository.findById(id);
    }

    @Override
    public GameRoomRealTimeResponse<GameRoomJoinData> joinToGameRoom(Long gameRoomId, Long userId) {
        User user = userRepository.userFindById(userId);
        CasinoChip casinoChip = casinoChipRepository.selectById(userId);
        GameRoom gameRoom = gameRoomRepository.findById(gameRoomId);

        GameRoomParticipant gameRoomParticipant = new GameRoomParticipant(gameRoom, user);
//        gamePlayHandler.joinGame(
//                new GameJoinDto(
//                        gameRoomId,
//                        userId
//                )
//        );

        gameRoomParticipantRepository.save(gameRoomParticipant);
        return new GameRoomRealTimeResponse<>(
                MessageType.JOIN,
                new GameRoomJoinData(
                        userId,
                        user.getNickname().getNickname(),
                        casinoChip.getMoney()
                        )
        );
    }

    @Override
    public GameRoomRealTimeResponse<GameRoomLeaveData> leaveGameRoom(Long gameRoomId, Long userId) {
        User user = userRepository.userFindById(userId);
        gameRoomParticipantRepository.removeByUser(user);

        return new GameRoomRealTimeResponse<>(
                MessageType.LEAVE,
                new GameRoomLeaveData(
                        userId
                )
        );
    }

    @Override
    public GameRoomInfoResponse getGameRoomInfo(Long roomId) {
        List<User> users = gameRoomParticipantRepository.findAllUserByRoomId(roomId);
        //TODO: 돈 내역이 들어가도록 수정
        GameRoomInfoResponse gameRoomInfoResponse = new GameRoomInfoResponse(users);
        return gameRoomInfoResponse;
    }


}
