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

    /** 변동된 머니 변동 후 확인에 사용 */
    private Long money;

    /** 보유 머니 변동량 */
    private Long rate;
}
