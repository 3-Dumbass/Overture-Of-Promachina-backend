package com.oops.OvertureOfPromachina.application.repository.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends SpringTestSetting {

    @Autowired
    private UserRepository userRepository;

    @Test
    void duplicateCheckUserTest(){
        User user = UserFixture.create();
        String loginId = user.getLoginId().getLoginId();
        userRepository.save(user);

        Boolean result = userRepository.DuplicateCheckUser(loginId);

        Assertions.assertThat(result);
    }
}
