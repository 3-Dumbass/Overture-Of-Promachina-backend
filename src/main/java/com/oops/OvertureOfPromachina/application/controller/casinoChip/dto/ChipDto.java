package com.oops.OvertureOfPromachina.application.controller.casinoChip.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChipDto {

    /** 칩 보유 유저 id */
    private Long user_id;

    /** 변동된 머니 */
    private Long money;

}
