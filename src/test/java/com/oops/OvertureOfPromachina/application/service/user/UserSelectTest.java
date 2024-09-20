package com.oops.OvertureOfPromachina.application.service.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.service.business.User.UserService;
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

        userService.save(user_save);

        Assertions.assertThat(userService.selectUserData(user_save.getLoginId().getLoginId(), user_save.getPwd().getPassword())).isNotNull();
    }


    @Test
    void SelectUserDataByNicknameTest(){
        User user_save = UserFixture.create();

        userService.save(user_save);

        Assertions.assertThat(userService.selectUserDataByNickname(user_save.getNickname().getNickname())).isNotNull();
    }

}
