package com.oops.OvertureOfPromachina.fixture;

import com.oops.OvertureOfPromachina.application.controller.user.dto.LoginDto;

public class LoginFixture {
    static public LoginDto create(){return new LoginDto("testLoginId", "testpwd");}
}
