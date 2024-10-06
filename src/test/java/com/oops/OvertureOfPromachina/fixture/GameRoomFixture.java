package com.oops.OvertureOfPromachina.fixture;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;

public class GameRoomFixture {
    public static GameRoom create(){
        return new GameRoom("test",GameModeEnum.WINNER_DISTRIBUTION);
    }
}
