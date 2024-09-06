package com.oops.OvertureOfPromachina.application.entity.GameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameMode;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameRoom {
    @Id
    @GeneratedValue
    @Column(name = "game_room_id")
    private Long id;

    @Embedded
    private GameMode gameMode;

    public GameRoom(GameModeEnum gameMode) {
        this.gameMode = new GameMode(gameMode);
    }
}
