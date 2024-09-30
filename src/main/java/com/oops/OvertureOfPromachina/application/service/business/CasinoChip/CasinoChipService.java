package com.oops.OvertureOfPromachina.application.service.business.CasinoChip;

import com.oops.OvertureOfPromachina.application.controller.casinoChip.dto.ChipDto;
import com.oops.OvertureOfPromachina.application.entity.casinoChip.CasinoChip;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.CasinoChip.CasinoChipRepository;
import com.oops.OvertureOfPromachina.application.service.business.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CasinoChipService {

    private final CasinoChipRepository casinoChipRepository;
    private final UserService userService;

    long default_money = 0;


    /** user의 기본 칩 생성
     * @param user_data
     * @return CasinoChip */
    public CasinoChip save(User user_data) {

        return casinoChipRepository.save(new CasinoChip(user_data, default_money));
    }


    /** 보유 머니 변동 Service
     * @param chipDto
     * @return CasinoChip */
    public CasinoChip chip_trade(ChipDto chipDto){

        User user_data = userService.selectUserData(chipDto.getUser_id());
        return casinoChipRepository.update(user_data, chipDto.getRate());
    }
}
