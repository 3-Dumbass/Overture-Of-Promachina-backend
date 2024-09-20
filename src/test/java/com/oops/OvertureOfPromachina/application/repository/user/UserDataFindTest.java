package com.oops.OvertureOfPromachina.application.repository.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDataFindTest extends SpringTestSetting {

    @Autowired
    UserRepository userRepository;

    @Test
    void findUser(){
        User user_save = UserFixture.create();
        userRepository.save(user_save);

        User user_data = userRepository.userFind(user_save.getLoginId().getLoginId(), user_save.getPwd().getPassword());

        Assertions.assertThat(user_data).isNotNull();
    }


    @Test
    void findByLoginId(){
        User user_save = UserFixture.create();
        userRepository.save(user_save);

        User user_data = userRepository.userFindByLogin(user_save.getLoginId().getLoginId());

        Assertions.assertThat(user_data).isNotNull();
    }


    @Test
    void findByNickname(){
        User user_save = UserFixture.create();
        userRepository.save(user_save);

        User user_data = userRepository.userFindByNickname(user_save.getNickname().getNickname());

        Assertions.assertThat(user_data).isNotNull();
    }
}
