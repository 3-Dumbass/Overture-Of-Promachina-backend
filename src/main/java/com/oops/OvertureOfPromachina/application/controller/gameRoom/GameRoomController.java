package com.oops.OvertureOfPromachina.application.controller.gameRoom;

import com.oops.OvertureOfPromachina.application.controller.gameRoom.dto.GameRoomCreateRequest;
import com.oops.OvertureOfPromachina.application.controller.gameRoom.dto.GameRoomJoinRequest;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.service.business.gameRoom.GameRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "game room api", description = "게임 방의 API 목록")
@RestController
@RequestMapping("/api/v1/game-room")
@RequiredArgsConstructor
public class GameRoomController {
    private final GameRoomService gameRoomService;


    @Operation(summary = "게임룸 제작", description = "게임룸을 제작합니다")
    @PostMapping("/create")
    public Long createGameRoom(@RequestBody @Valid GameRoomCreateRequest gameRoomCreateRequest){
        User user = null;
        return gameRoomService.makeRoom(gameRoomCreateRequest.getGameMode());
    }

    @Operation(summary = "게임룸 입장", description = "유저가 해당 게임룸에 입장합니다")
    @PostMapping("/join")
    public Long joinGameRoom(@RequestBody @Valid GameRoomJoinRequest gameRoomJoinRequest){
        User user = null;
        GameRoom gameRoom = null;

        return gameRoomService.joinToGameRoom(gameRoom, user);
    }
}
