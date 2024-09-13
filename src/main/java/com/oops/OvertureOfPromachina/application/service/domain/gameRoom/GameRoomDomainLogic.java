package com.oops.OvertureOfPromachina.application.service.domain.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import org.springframework.stereotype.Component;

@Component
public class GameRoomDomainLogic {

    public GameRoom makeGameRoom(GameModeEnum gameMode){
        return new GameRoom(gameMode);
    }
}
