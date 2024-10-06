package com.oops.OvertureOfPromachina.application.controller.gameRoomRealTime;

import com.oops.OvertureOfPromachina.application.controller.gameRoomRealTime.dto.GameRoomJoinRequest;
import com.oops.OvertureOfPromachina.application.controller.gameRoomRealTime.dto.GameRoomLeaveRequest;
import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.GameRoomRealTimeResponse;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.data.GameRoomJoinData;
import com.oops.OvertureOfPromachina.application.responseDto.gameRoomRealTime.data.GameRoomLeaveData;
import com.oops.OvertureOfPromachina.application.service.business.gameRoom.GameRoomService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class GameRoomRealTimeController {

    private final GameRoomService gameRoomService;
    @MessageMapping("/join/{roomId}")
    @SendTo("/room/{roomId}")
    public ResponseEntity<GameRoomRealTimeResponse<GameRoomJoinData>> joinGameRoom(@DestinationVariable Long roomId,
                                                                                   @RequestBody @Valid GameRoomJoinRequest gameRoomJoinRequest){
        GameRoomRealTimeResponse<GameRoomJoinData> result =
                gameRoomService.joinToGameRoom(roomId, gameRoomJoinRequest.getUserId());

        return ResponseEntity.ok()
                .body(result);
    }

    @MessageMapping("/leave/{roomId}")
    @SendTo("/room/{roomId}")
    public ResponseEntity<GameRoomRealTimeResponse<GameRoomLeaveData>> leaveGameRoom(@DestinationVariable Long roomId,
                                                                                     @RequestBody @Valid GameRoomLeaveRequest gameRoomLeaveRequest){

        GameRoomRealTimeResponse<GameRoomLeaveData> result =
                gameRoomService.leaveGameRoom(roomId, gameRoomLeaveRequest.getUserId());

        return ResponseEntity.ok()
                .body(result);
    }
}
