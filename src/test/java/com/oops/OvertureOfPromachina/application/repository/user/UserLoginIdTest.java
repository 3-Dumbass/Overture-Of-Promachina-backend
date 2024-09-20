package com.oops.OvertureOfPromachina.application.repository.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class UserLoginIdTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void duplicate_exist_value_test(){
        User user = UserFixture.create();
        String login_id = user.getLoginId().getLoginId();
        userRepository.save(user);

        Assertions.assertThat(login_id).isEqualTo(userRepository.loginIdByLoginId(login_id));
    }

    @Test
    void duplicate_non_exist_value_test(){
        String login_id = " ";

        Assertions.assertThat(userRepository.loginIdByLoginId(login_id)).isNull();
    }

}
