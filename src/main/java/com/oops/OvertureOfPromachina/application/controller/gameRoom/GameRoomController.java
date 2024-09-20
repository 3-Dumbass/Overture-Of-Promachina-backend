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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "game room api", description = "게임 방의 API 목록")
@RestController
@RequestMapping("/api/v1/game-room")
@RequiredArgsConstructor
public class GameRoomController {
    private final GameRoomService gameRoomService;


    @Operation(summary = "게임룸 제작", description = "게임룸을 제작합니다")
    @PostMapping("/create")
    public ResponseEntity<Long> createGameRoom(@RequestBody @Valid GameRoomCreateRequest gameRoomCreateRequest){
        Long result = gameRoomService.makeRoom(gameRoomCreateRequest.getGameMode());
        return ResponseEntity.ok()
                .body(result);
    }

    @Operation(summary = "게임룸 입장", description = "유저가 해당 게임룸에 입장합니다")
    @PostMapping("/join")
    public ResponseEntity<Long> joinGameRoom(@RequestBody @Valid GameRoomJoinRequest gameRoomJoinRequest){
        User user = null;
        GameRoom gameRoom = null;
        Long result = gameRoomService.joinToGameRoom(gameRoom, user);

        return ResponseEntity.ok()
                .body(result);
    }

    @Operation(summary = "게임룸 입장 가능 여부 확인", description = "유저가 해당 게임룸에 입장가능한지 확인 합니다")
    @PostMapping("/join-check")
    public ResponseEntity<Long> joinGameRoomCheck(@RequestBody @Valid GameRoomJoinRequest gameRoomJoinRequest){
        User user = null;
        GameRoom gameRoom = null;

        return ResponseEntity.ok().body(null);
    }
}
