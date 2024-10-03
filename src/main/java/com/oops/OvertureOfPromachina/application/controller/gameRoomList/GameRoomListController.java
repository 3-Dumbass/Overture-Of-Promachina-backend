package com.oops.OvertureOfPromachina.application.controller.gameRoomList;

import com.oops.OvertureOfPromachina.application.responseDto.gameRoomList.GameRoomMetadataResponse;
import com.oops.OvertureOfPromachina.application.responseDto.pagination.PaginationResultResponse;
import com.oops.OvertureOfPromachina.application.service.business.gameRoomList.GameRoomListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "game room list api", description = "게임 방 리스트의 API 목록")
@RestController
@RequestMapping("/api/v1/game-room-list")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")//TODO: 변경 필요
public class GameRoomListController {

    private final GameRoomListService gameRoomListService;


    @Operation(summary = "게임룸 리스트 조회", description = "게임룸들에 대한 정보들을 페이지 단위로 조회함")
    @GetMapping("/list")
    public ResponseEntity<PaginationResultResponse<GameRoomMetadataResponse>> getGameRoomList(
            @RequestParam(defaultValue = "0")@Parameter(description = "현재 페이지")Long page,
            @RequestParam(defaultValue = "7")@Parameter(description = "받아올 개수")Long size
    ){
        PaginationResultResponse<GameRoomMetadataResponse> result = gameRoomListService.getGameRoomList(page, size);
        return ResponseEntity.ok().body(result);
    }
}
