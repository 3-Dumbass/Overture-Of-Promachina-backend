package com.oops.OvertureOfPromachina.common.gamePlayHandler.object;

import com.oops.OvertureOfPromachina.common.gamePlayHandler.object.type.GameStep;
import lombok.Getter;

import java.util.List;

@Getter
public class Game {
    private final Long roomId;
    private final List<Long> userIdList;
    private GameStep gameStep;

    public Game(Long roomId, List<Long> userIdList) {
        this.roomId = roomId;
        this.userIdList = userIdList;
        gameStep = GameStep.BETTING;
    }
}
