package com.oops.OvertureOfPromachina.application.service.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.service.business.User.UserService;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSaveTest extends SpringTestSetting {

    @Autowired
    private UserService userService;


    @Test
    void SaveUser(){
        User user_save = UserFixture.create();
        Assertions.assertThat(userService.save(user_save)).isEqualTo(true);

    }


}
