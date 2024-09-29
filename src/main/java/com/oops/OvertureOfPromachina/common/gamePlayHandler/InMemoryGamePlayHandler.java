package com.oops.OvertureOfPromachina.common.gamePlayHandler;

import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.GameStartDto;
import com.oops.OvertureOfPromachina.common.gamePlayHandler.object.Game;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryGamePlayHandler implements GamePlayHandler{

    Map<Long, Game> gameList = new ConcurrentHashMap<>();

    @Override
    public void startGame(GameStartDto gameStartDto) {
        Game game = new Game(gameStartDto.getRoomId(), gameStartDto.getUserIds());
        gameList.put(game.getRoomId(), game);
    }

    @Override
    public void nextTurn(Long roomId) {
        gameList.get(roomId).nextTurn();
    }

    @Override
    public void nextTurnIfFinishAllPlayer(Long roomId) {
        Game game = gameList.get(roomId);
        if(game.checkAllPlayerFinish()){
            nextTurn(roomId);
        }
    }
}
