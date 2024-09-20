package com.oops.OvertureOfPromachina.application.service.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.service.business.User.UserService;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDuplicateCheckTest extends SpringTestSetting {

    @Autowired
    UserService userService;


    @Test
    void duplicate_loginId_false(){
        User user_save = UserFixture.create();
        userService.save(user_save);

        Assertions.assertThat(userService.duplicateLoginId(user_save.getLoginId().getLoginId())).isEqualTo(false);
    }


    @Test
    void duplicate_loginId_true(){
        User user_save = UserFixture.create();
        userService.save(user_save);

        Assertions.assertThat(userService.duplicateLoginId("non_id")).isEqualTo(true);
    }


    @Test
    void duplicate_nickname_false(){
        User user_save = UserFixture.create();
        userService.save(user_save);

        Assertions.assertThat(userService.duplicateNickname(user_save.getNickname().getNickname())).isEqualTo(false);
    }


    @Test
    void duplicate_nickname_true(){
        User user_save = UserFixture.create();
        userService.save(user_save);

        Assertions.assertThat(userService.duplicateNickname("non_nickname")).isEqualTo(true);
    }

}
