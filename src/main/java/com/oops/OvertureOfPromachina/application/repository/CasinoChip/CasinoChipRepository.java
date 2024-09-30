package com.oops.OvertureOfPromachina.application.repository.CasinoChip;

import com.oops.OvertureOfPromachina.application.entity.casinoChip.CasinoChip;
import com.oops.OvertureOfPromachina.application.entity.user.User;

public interface CasinoChipRepository {

    CasinoChip save(CasinoChip casinoChip_data);

    CasinoChip update(User user_id, long rate);

    CasinoChip selectById(long id);
}
