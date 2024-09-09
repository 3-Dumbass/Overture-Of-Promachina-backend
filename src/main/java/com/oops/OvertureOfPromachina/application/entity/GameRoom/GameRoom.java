package com.oops.OvertureOfPromachina.application.entity.GameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameMode;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject.GameModeEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class GameRoom {
    @Id
    @GeneratedValue
    @Column(name = "game_room_id")
    private Long id;

    @Embedded
    private GameMode gameMode;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    public GameRoom(GameModeEnum gameMode) {
        this.gameMode = new GameMode(gameMode);
    }
}
