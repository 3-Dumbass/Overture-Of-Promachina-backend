package com.oops.OvertureOfPromachina.application.entity.GameRoom.valueObject;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GameRoomTitle {
    private String title;

    public GameRoomTitle(String title) {
        checkValid(title);
        this.title = title;
    }

    private void checkValid(String  title){
        if(title==null){
            throw new IllegalArgumentException("게임 룸의 제목이 null입니다");
        }
        if(title.isBlank()){
            throw new IllegalArgumentException("게임 룸의 제목이 비어있습니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRoomTitle that = (GameRoomTitle) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
