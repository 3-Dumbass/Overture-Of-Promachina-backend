package com.oops.OvertureOfPromachina.application.controller.gameRoom;

import com.oops.OvertureOfPromachina.application.controller.gameRoom.dto.GameRoomCreateRequest;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoom.GameRoomInfoResponse;
import com.oops.OvertureOfPromachina.application.service.business.gameRoom.GameRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "game room api", description = "게임 방의 API 목록")
@RestController
@RequestMapping("/api/v1/game-room")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(originPatterns = "*")//TODO: 변경 필요
public class GameRoomController {
    private final GameRoomService gameRoomService;


    @Operation(summary = "게임룸 제작", description = "게임룸을 제작합니다")
    @PostMapping("/create")
    public ResponseEntity<Long> createGameRoom(@RequestBody @Valid GameRoomCreateRequest gameRoomCreateRequest){
        log.info(gameRoomCreateRequest.getGameMode());
        Long result = gameRoomService.makeRoom(gameRoomCreateRequest.getGameMode());
        return ResponseEntity.ok()
                .body(result);
    }

    @Operation(summary = "게임 룸 정보 가져오기", description = "게임 룸의 정보를 가져옴")
    @PostMapping("/roomInfo")
    public ResponseEntity<GameRoomInfoResponse> getRoomInfo(@RequestBody @Valid Long roomId){
        GameRoomInfoResponse result = gameRoomService.getGameRoomInfo(roomId);
        return ResponseEntity.ok()
                .body(result);
    }

}
