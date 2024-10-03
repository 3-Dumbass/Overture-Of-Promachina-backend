package com.oops.OvertureOfPromachina.application.repository.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GameRoomRepositoryTest extends SpringTestSetting {

    @Autowired
    private GameRoomRepository gameRoomRepository;

    @Test
    void saveTest(){
        GameRoom gameRoom = new GameRoom("test",GameModeEnum.WINNER_DISTRIBUTION);

        Long id = gameRoomRepository.save(gameRoom);

        GameRoom result = gameRoomRepository.findById(id);

        Assertions.assertThat(result).isSameAs(gameRoom);
    }
}
