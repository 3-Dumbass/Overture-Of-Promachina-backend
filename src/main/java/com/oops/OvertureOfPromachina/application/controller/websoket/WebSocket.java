package com.oops.OvertureOfPromachina.application.controller.websoket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
//test
@RestController("/web")
@Slf4j
public class WebSocket {
    /***
     * publish [pub/comm/message/{teamId}]
     */
    @MessageMapping("/comm/message/{teamId}")
    @SendTo("/sub/comm/room/{teamId}")
    public Message message(@DestinationVariable String teamId,
                           Message message) {
        return message;
    }

    /*
    publish [pub/comm/item/{teamId}]
     */
    @MessageMapping("/comm/item/{teamId}")
    @SendTo("/sub/comm/item/{teamId}")
    public String message(@DestinationVariable String teamId,
                               String message) {

        log.info("Item Message : " + message);

        return message;
    }
}
