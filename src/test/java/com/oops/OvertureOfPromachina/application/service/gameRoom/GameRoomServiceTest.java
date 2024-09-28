package com.oops.OvertureOfPromachina.application.service.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.service.business.gameRoom.GameRoomService;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GameRoomServiceTest extends SpringTestSetting {

    @Autowired
    private GameRoomService gameRoomService;

    @Test
    void makeGameRoomTest(){
        String gameMode = "WINNER_TAKE_ALL";
        Long id = gameRoomService.makeRoom(gameMode);

        GameRoom result = gameRoomService.findGameRoomById(id);

        Assertions.assertThat(result.getGameMode().getGameMode().toString()).isEqualTo(gameMode);

    }
}
