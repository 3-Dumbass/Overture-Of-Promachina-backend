package com.oops.OvertureOfPromachina.application.repository.chip;

import com.oops.OvertureOfPromachina.application.entity.casinoChip.CasinoChip;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.CasinoChip.CasinoChipRepository;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.fixture.CasinoChipFixture;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChipRepositoryTest extends SpringTestSetting {

    @Autowired
    CasinoChipRepository casinoChipRepository;

    @Autowired
    UserRepository userRepository;

    User user;

    @BeforeEach
    void userSetup(){

        user = UserFixture.create();
        userRepository.save(user);
    }


    @Test
    void saveTest(){

        CasinoChip casinoChip = CasinoChipFixture.create(user);
        Assertions.assertNotNull(casinoChipRepository.save(casinoChip));
    }


    @Test
    void updateTest(){

        CasinoChip casinoChip = CasinoChipFixture.create(user);
        casinoChipRepository.save(casinoChip);

        CasinoChip updateChip = casinoChipRepository.update(user, -5000L);
        Assertions.assertNotNull(updateChip);
    }
}
