package com.oops.OvertureOfPromachina.application.repository.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserPriKeyByNicknameTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void FindPriKeyByNicknameTest(){
        User user = UserFixture.create();
        String nickname = user.getNickname().getNickname();
        String priKey = user.getPriKey().getPrivateKey();
        userRepository.save(user);

        Assertions.assertThat(priKey).isEqualTo(userRepository.priKeyByNickname(nickname));

    }
}
