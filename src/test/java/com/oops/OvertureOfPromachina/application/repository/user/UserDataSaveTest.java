package com.oops.OvertureOfPromachina.application.repository.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import com.oops.OvertureOfPromachina.fixture.UserFixture;
import com.oops.OvertureOfPromachina.testSetting.SpringTestSetting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserDataSaveTest extends SpringTestSetting{

    @Autowired
    UserRepository userRepository;

    @Test
    void userSave(){
        User user_data = UserFixture.create();
        Long user_id = userRepository.save(user_data);

        System.out.println("user_save_test: " + user_id);
        Assertions.assertThat(user_id).isNotNull();
    }

    @Test
    void userFindById(){

    }

}
