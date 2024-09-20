package com.oops.OvertureOfPromachina.application.repository.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.DbUserRepository;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


public class UserAccountByNicknameTest extends SpringTestSetting{

    @Autowired
    UserRepository userRepository;

    @Test
    void FindAccountByNicknameTest(){
        User user = UserFixture.create();
        String nickname = user.getNickname().getNickname();
        String account = user.getAccount().getAccount();
        userRepository.save(user);

        Assertions.assertThat(account).isEqualTo(userRepository.accountByNickname(nickname));

    }

}
