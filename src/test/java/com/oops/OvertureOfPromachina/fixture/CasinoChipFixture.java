package com.oops.OvertureOfPromachina.fixture;

import com.oops.OvertureOfPromachina.application.entity.casinoChip.CasinoChip;
import com.oops.OvertureOfPromachina.application.entity.user.User;

public class CasinoChipFixture {

    static public CasinoChip create(User user){

        long test_money = 10000;

        return new CasinoChip(user, test_money);
    }
}
