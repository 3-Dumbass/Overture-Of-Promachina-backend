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
        this.gameStep = GameStep.PLAYING;
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
        return true;
    }
}
