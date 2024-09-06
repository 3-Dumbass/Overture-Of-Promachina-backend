package com.oops.OvertureOfPromachina.application.entity.valueObject.user;


import com.oops.OvertureOfPromachina.application.entity.user.valueObject.UserPassword;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserPasswordTest {
    @Test
    void formalTest1(){
        String value = "ab456";
        UserPassword valueObject = new UserPassword(value);
        Assertions.assertThat(valueObject.getPassword()).isEqualTo(value);
    }

    @Test
    void formalTest2(){
        String value = "ab456dnh";
        UserPassword valueObject = new UserPassword(value);
        Assertions.assertThat(valueObject.getPassword()).isEqualTo(value);
    }

    @Test
    void nullErrorTest(){
        String value = null;
        Assertions.assertThatThrownBy(() -> {
            UserPassword valueObject = new UserPassword(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyErrorTest(){
        String value = "";
        Assertions.assertThatThrownBy(() -> {
            UserPassword valueObject = new UserPassword(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void blankErrorTest(){
        String value = "   ";
        Assertions.assertThatThrownBy(() -> {
            UserPassword valueObject = new UserPassword(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
