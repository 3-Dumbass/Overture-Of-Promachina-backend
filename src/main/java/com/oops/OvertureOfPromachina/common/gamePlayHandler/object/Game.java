package com.oops.OvertureOfPromachina.common.gamePlayHandler.object;

import com.oops.OvertureOfPromachina.common.gamePlayHandler.object.type.GameStep;
import lombok.Getter;

import java.util.ArrayList;
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

    public Game(Long roomId) {
        this.roomId = roomId;
        this.playerList = new ArrayList<>();
        this.finishPlayerIds = new ConcurrentSkipListSet<>();
        this.gameStep = GameStep.WAITING;
    }

    public void join(Long userId){
        playerList.add(new Player(userId));
    }

    public void nextTurn(){
        this.finishPlayerIds = new ConcurrentSkipListSet<>();
    }

    public void finish(){
        this.gameStep = GameStep.FINISH;
    }

    public boolean checkAllPlayerFinish(){
        boolean finish = true;
        for(Player player:playerList){
            if (!finishPlayerIds.contains(player.getId())) {
                finish = false;
                break;
            }
        }
        return finish;
    }
}
