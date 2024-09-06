package com.oops.OvertureOfPromachina.application.entity.valueObject.user;

import com.oops.OvertureOfPromachina.application.entity.user.valueObject.UserLoginId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserPasswordTest {
    @Test
    void formalTest1(){
        String value = "ab456";
        UserLoginId valueObject = new UserLoginId(value);
        Assertions.assertThat(valueObject.getLoginId()).isEqualTo(value);
    }

    @Test
    void formalTest2(){
        String value = "ab456dnh";
        UserLoginId valueObject = new UserLoginId(value);
        Assertions.assertThat(valueObject.getLoginId()).isEqualTo(value);
    }

    @Test
    void nullErrorTest(){
        String value = null;
        Assertions.assertThatThrownBy(() -> {
            UserLoginId valueObject = new UserLoginId(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyErrorTest(){
        String value = "";
        Assertions.assertThatThrownBy(() -> {
            UserLoginId valueObject = new UserLoginId(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void blankErrorTest(){
        String value = "   ";
        Assertions.assertThatThrownBy(() -> {
            UserLoginId valueObject = new UserLoginId(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
