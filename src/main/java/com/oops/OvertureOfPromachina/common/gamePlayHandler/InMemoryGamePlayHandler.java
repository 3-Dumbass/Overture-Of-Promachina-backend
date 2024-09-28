package com.oops.OvertureOfPromachina.common.gamePlayHandler;

import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.BettingDto;
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
    public Boolean betting(BettingDto bettingDto) {
        return null;
    }

    @Override
    public Boolean checkAllPeopleBetting() {
        return null;
    }
}
