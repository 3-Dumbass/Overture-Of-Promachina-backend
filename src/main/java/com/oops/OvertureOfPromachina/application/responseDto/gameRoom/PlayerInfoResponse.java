package com.oops.OvertureOfPromachina.application.responseDto.gameRoom;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PlayerInfoResponse {
    private Long userId;

    private String nickname;

    private Long money;
}
