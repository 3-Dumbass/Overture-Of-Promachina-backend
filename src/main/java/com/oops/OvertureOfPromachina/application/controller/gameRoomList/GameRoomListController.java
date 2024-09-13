package com.oops.OvertureOfPromachina.application.controller.gameRoomList;

import com.oops.OvertureOfPromachina.application.responseDto.gameRoomList.GameRoomMetadataResponse;
import com.oops.OvertureOfPromachina.application.responseDto.pagination.PaginationResultResponse;
import com.oops.OvertureOfPromachina.application.service.business.gameRoomList.GameRoomListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "game room list api", description = "게임 방 리스트의 API 목록")
@RestController
@RequestMapping("/api/v1/game-room-list")
@RequiredArgsConstructor
public class GameRoomListController {

    private final GameRoomListService gameRoomListService;


    @Operation(summary = "학과 공지 게시글 리스트 조회", description = "학과 공지 게시글의 리스트 조회를 조회합니다")
    @GetMapping("/list")
    public ResponseEntity<PaginationResultResponse<GameRoomMetadataResponse>> getGameRoomList(
            @RequestParam(defaultValue = "0")@Parameter(description = "현재 페이지")Long page,
            @RequestParam(defaultValue = "7")@Parameter(description = "받아올 개수")Long size
    ){
        PaginationResultResponse<GameRoomMetadataResponse> result = gameRoomListService.getGameRoomList(page, size);
        return ResponseEntity.ok().body(result);
    }
}
