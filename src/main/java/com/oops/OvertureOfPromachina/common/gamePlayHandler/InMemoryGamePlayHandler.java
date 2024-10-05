package com.oops.OvertureOfPromachina.common.gamePlayHandler;

import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.GameJoinDto;
import com.oops.OvertureOfPromachina.common.gamePlayHandler.dto.GameMakeDto;
import com.oops.OvertureOfPromachina.common.gamePlayHandler.object.Game;
import com.oops.OvertureOfPromachina.common.gamePlayHandler.object.type.GameStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class InMemoryGamePlayHandler implements GamePlayHandler{

    Map<Long, Game> gameList = new ConcurrentHashMap<>();

    @Override
    public void makeGame(GameMakeDto gameMakeDto) {
        log.info("make game:" + gameMakeDto.getRoomId());
        Game game = new Game(gameMakeDto.getRoomId());
        gameList.put(game.getRoomId(), game);
        log.info("total room amount: " + gameList.size());
    }

    @Override
    public void joinGame(GameJoinDto gameJoinDto) {
        Game game = gameList.get(gameJoinDto.getRoomId());
        if(game.getGameStep()!= GameStep.WAITING)
        game.join(gameJoinDto.getUserId());
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

    @Override
    public void finish(Long roomId) {
        Game game = gameList.get(roomId);
        game.finish();
    }
}
