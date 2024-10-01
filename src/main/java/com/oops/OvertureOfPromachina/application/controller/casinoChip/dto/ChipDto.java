package com.oops.OvertureOfPromachina.application.controller.casinoChip.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChipDto {

    /** 칩 보유 유저 id */
    private Long user_id;

    /** 변동된 머니 */
    private Long money;

}
