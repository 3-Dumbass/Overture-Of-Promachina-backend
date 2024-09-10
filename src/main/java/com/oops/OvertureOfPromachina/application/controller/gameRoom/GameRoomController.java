package com.oops.OvertureOfPromachina.application.controller.gameRoom;

import com.oops.OvertureOfPromachina.application.service.business.gameRoom.GameRoomService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "game room api", description = "게임 방의 API 목록")
@RestController
@RequestMapping("/api/v1/game-room")
@RequiredArgsConstructor
public class GameRoomController {
    private final GameRoomService gameRoomService;

}
