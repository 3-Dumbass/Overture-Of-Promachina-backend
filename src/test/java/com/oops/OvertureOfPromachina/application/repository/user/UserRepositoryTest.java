package com.oops.OvertureOfPromachina.application.repository.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;

public class UserRepositoryTest extends SpringTestSetting {

    @Autowired
    private UserRepository userRepository;

    @Test
    void duplicateCheckUserTest(){
        User user = UserFixture.create();
        String login_id = user.getLoginId().getLoginId();
        userRepository.save(user);

        Boolean result = userRepository.DuplicateCheckUser(login_id);

        Assertions.assertThat(result);
    }

    @Test
    void duplicateCheckNicknameTest(){
        User user = UserFixture.create();
        String nickname = user.getNickname().getNickname();
        userRepository.save(user);

        Boolean result = userRepository.DuplicateCheckNickname(nickname);
        Assertions.assertThat(result);
    }

    @Test
    void FindNicknameByLoginIdTest(){
        User user = UserFixture.create();
        String login_id = user.getLoginId().getLoginId();
        String nickname = user.getNickname().getNickname();
        userRepository.save(user);

        String find_nickname = userRepository.FindNicknameByLoginId(login_id);
        Assertions.assertThat(find_nickname).isEqualTo(nickname);
    }

    @Test
    void FindAccountAndPriKeyByNicknameTest(){
        User user = UserFixture.create();
        String nickname = user.getNickname().getNickname();
        String account = user.getAccount().getAccount();
        String priKey = user.getPriKey().getPrivateKey();
        userRepository.save(user);

        Pair<String, String> testing_pair = Pair.of(account, priKey);

        Assertions.assertThat(testing_pair).isEqualTo(userRepository.FindAccountAndPriKeyByNickname(nickname));

    }
}
