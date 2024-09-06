package com.oops.OvertureOfPromachina.application.entity.room.valueObject;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GameMode {
    @Enumerated(value = EnumType.STRING)
    private GameModeEnum gameMode;

    public GameMode(GameModeEnum gameMode) {
        checkValid(gameMode);
        this.gameMode = gameMode;
    }

    private void checkValid(GameModeEnum gameMode){
        if(gameMode==null){
            throw new IllegalArgumentException("게임 모드가 null 입니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameMode gameMode1 = (GameMode) o;
        return gameMode == gameMode1.gameMode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameMode);
    }
}
