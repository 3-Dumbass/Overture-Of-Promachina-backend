package com.oops.OvertureOfPromachina.application.repository.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


public class UserNicknameTest extends SpringTestSetting {

    @Autowired
    UserRepository userRepository;

    @Test
    void duplicate_exist_value_test(){
        User user = UserFixture.create();
        String nickname = user.getNickname().getNickname();
        userRepository.save(user);

        Assertions.assertThat(nickname).isEqualTo(userRepository.nicknameByNickname(nickname));
    }

    @Test
    void duplicate_non_exist_value_test(){
        String nickname = " ";

        Assertions.assertThat(userRepository.nicknameByNickname(nickname)).isNull();
    }
}
