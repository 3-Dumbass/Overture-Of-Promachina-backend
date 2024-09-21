package com.oops.OvertureOfPromachina.application.service.user;

import com.oops.OvertureOfPromachina.application.controller.user.dto.LoginDto;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.service.business.User.UserService;
import com.oops.OvertureOfPromachina.fixture.LoginFixture;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSelectTest extends SpringTestSetting {

    @Autowired
    UserService userService;


    @Test
    void SelectUserDataTest(){
        User user_save = UserFixture.create();
        LoginDto loginDto = LoginFixture.create();
        userService.save(user_save);

        Assertions.assertThat(userService.selectUserData(loginDto)).isNotNull();
    }


    @Test
    void SelectUserDataByNicknameTest(){
        User user_save = UserFixture.create();

        userService.save(user_save);

        Assertions.assertThat(userService.selectUserDataByNickname(user_save.getNickname().getNickname())).isNotNull();
    }

}
