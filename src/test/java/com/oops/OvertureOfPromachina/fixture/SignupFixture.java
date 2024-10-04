package com.oops.OvertureOfPromachina.fixture;

import com.oops.OvertureOfPromachina.application.controller.user.dto.SignupDto;

public class SignupFixture {
    static public SignupDto create(){

        return new SignupDto("testNickname","testLoginId", "testpwd");
    }
}
