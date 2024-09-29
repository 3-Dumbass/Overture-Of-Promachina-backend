package com.oops.OvertureOfPromachina.common.gamePlayHandler.object;

import com.oops.OvertureOfPromachina.common.gamePlayHandler.object.type.GameStep;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@Getter
public class Game {
    private final Long roomId;
    private final List<Player> playerList;
    private Set<Long> finishPlayerIds;
    private GameStep gameStep;

    public Game(Long roomId, List<Long> userIdList) {
        this.roomId = roomId;
        this.playerList = userIdList.stream().map(Player::new).toList();
        this.finishPlayerIds = new ConcurrentSkipListSet<>();
        this.gameStep = GameStep.BETTING;
    }
}
