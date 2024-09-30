package com.oops.OvertureOfPromachina.application.repository.CasinoChip;

import com.oops.OvertureOfPromachina.application.entity.casinoChip.CasinoChip;
import com.oops.OvertureOfPromachina.application.entity.user.User;

public interface CasinoChipRepository {

    /** user의 보유 머니 튜플 생성
     * @param casinoChip_data
     * @return CasinoChip */
    CasinoChip save(CasinoChip casinoChip_data);


    /** user의 보유 머니 변동 Repository
     * @params user_id, rate
     * @return CasinoChip */
    CasinoChip update(User user_id, long rate);


    /** user_id 기준 CasinoChip객체 반환
     * @param id
     * @return CasinoChip */
    CasinoChip selectById(long id);
}
