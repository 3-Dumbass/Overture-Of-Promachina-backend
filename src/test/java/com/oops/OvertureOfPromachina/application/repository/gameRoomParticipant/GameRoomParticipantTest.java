package com.oops.OvertureOfPromachina.application.repository.gameRoomParticipant;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.gameRoomParticipant.GameRoomParticipant;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.application.repository.gameRoom.GameRoomRepository;
import com.oops.OvertureOfPromachina.fixture.GameRoomFixture;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GameRoomParticipantTest extends SpringTestSetting {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRoomRepository gameRoomRepository;
    @Autowired
    private GameRoomParticipantRepository gameRoomParticipantRepository;

    User user1;
    User user2;
    GameRoom gameRoom;

    @BeforeEach
    void setup(){
        user1 = UserFixture.create(1L);
        user2 = UserFixture.create(2L);
        gameRoom = GameRoomFixture.create();

        userRepository.save(user1);
        userRepository.save(user2);
        gameRoomRepository.save(gameRoom);
    }

    @Test
    public void findAllUserByRoomIdTest(){
        GameRoomParticipant gameRoomParticipant1 = new GameRoomParticipant(gameRoom, user1);
        GameRoomParticipant gameRoomParticipant2 = new GameRoomParticipant(gameRoom, user2);
        gameRoomParticipantRepository.save(gameRoomParticipant1);
        gameRoomParticipantRepository.save(gameRoomParticipant2);

        List<User> result = gameRoomParticipantRepository.findAllUserByRoomId(gameRoom.getId());

        Assertions.assertThat(result).contains(user1);
        Assertions.assertThat(result).contains(user2);
    }
}
