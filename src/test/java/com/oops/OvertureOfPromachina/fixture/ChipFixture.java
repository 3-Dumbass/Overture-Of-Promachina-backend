package com.oops.OvertureOfPromachina.fixture;

import com.oops.OvertureOfPromachina.application.controller.casinoChip.dto.ChipDto;

public class ChipFixture {
    static long test_id = 1;
    static long test_money = 10000;
    static long test_rate = -5000;

    static public ChipDto create(){

        return new ChipDto(test_id, test_money, test_rate);
    }
}
