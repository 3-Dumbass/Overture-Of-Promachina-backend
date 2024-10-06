package com.oops.OvertureOfPromachina.application.responseDto.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import lombok.Getter;

import java.util.List;

@Getter
public class GameRoomInfoResponse {
    List<PlayerInfoResponse> playerList;

    public GameRoomInfoResponse(List<User> users) {
        this.playerList = users.stream().map(user -> new PlayerInfoResponse(
                user.getId(),
                user.getNickname().getNickname(),
                0L
        )).toList();
    }
}
