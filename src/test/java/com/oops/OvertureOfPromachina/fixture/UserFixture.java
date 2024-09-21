package com.oops.OvertureOfPromachina.fixture;

import com.oops.OvertureOfPromachina.application.controller.user.dto.LoginDto;
import com.oops.OvertureOfPromachina.application.entity.user.User;

public class UserFixture {
    static public User create(){
        return new User("test", "testLoginId", "testpwd", "testaccount", "testprikey");
    }
}
