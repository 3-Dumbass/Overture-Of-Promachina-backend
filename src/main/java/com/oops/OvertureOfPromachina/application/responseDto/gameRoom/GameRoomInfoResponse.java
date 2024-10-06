package com.oops.OvertureOfPromachina.application.responseDto.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import lombok.Getter;

import java.util.List;

@Getter
public class GameRoomInfoResponse {
    List<PlayerInfoResponse> playerList;

    public GameRoomInfoResponse(List<PlayerInfoResponse> players) {
        this.playerList = players;
    }
}
