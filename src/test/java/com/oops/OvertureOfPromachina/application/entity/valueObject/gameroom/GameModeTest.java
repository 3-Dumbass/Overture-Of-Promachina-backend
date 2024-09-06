package com.oops.OvertureOfPromachina.application.entity.valueObject.gameroom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameMode;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameModeTest {
    @Test
    void formalTest(){
        GameModeEnum value = GameModeEnum.WINNER_TAKE_ALL;
        GameMode gameMode = new GameMode(value);
        Assertions.assertThat(gameMode.getGameMode()).isEqualTo(value);
    }

    @Test
    void nullErrorTest(){
        GameModeEnum value = null;
        Assertions.assertThatThrownBy(() -> {
            GameMode gameMode = new GameMode(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
