package com.oops.OvertureOfPromachina.application.repository.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserNicknameByLoginIdTest {

    @Autowired
    UserRepository userRepository;


    @Test
    void FindNicknameByLoginIdTest(){
        User user = UserFixture.create();
        String login_id = user.getLoginId().getLoginId();
        String nickname = user.getNickname().getNickname();
        userRepository.save(user);

        Assertions.assertThat(nickname).isEqualTo(userRepository.nicknameByLoginId(login_id));
    }
}
