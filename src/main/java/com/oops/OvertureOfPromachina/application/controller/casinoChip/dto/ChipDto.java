package com.oops.OvertureOfPromachina.application.controller.casinoChip.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChipDto {

    private long user_id;
    private long money;
    private long rate;
}
