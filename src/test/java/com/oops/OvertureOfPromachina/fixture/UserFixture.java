package com.oops.OvertureOfPromachina.fixture;

import com.oops.OvertureOfPromachina.application.entity.user.User;

public class UserFixture {
    static public User create(){

        return new User("test", "testLoginId", "testpwd","1");
    }
    static public User create(Long num){

        return new User("test"+num.toString(), "testLoginId"+num.toString(), "testpwd","1");
    }
}
