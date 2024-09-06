package com.oops.OvertureOfPromachina.application.entity.valueObject.user;

import com.oops.OvertureOfPromachina.application.entity.user.valueObject.UserAccount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserAccountTest {
    @Test
    void formalTest1(){
        String value = "ab456";
        UserAccount valueObject = new UserAccount(value);
        Assertions.assertThat(valueObject.getAccount()).isEqualTo(value);
    }

    @Test
    void formalTest2(){
        String value = "ab456dnh";
        UserAccount valueObject = new UserAccount(value);
        Assertions.assertThat(valueObject.getAccount()).isEqualTo(value);
    }

    @Test
    void nullErrorTest(){
        String value = null;
        Assertions.assertThatThrownBy(() -> {
            UserAccount valueObject = new UserAccount(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyErrorTest(){
        String value = "";
        Assertions.assertThatThrownBy(() -> {
            UserAccount valueObject = new UserAccount(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void blankErrorTest(){
        String value = "   ";
        Assertions.assertThatThrownBy(() -> {
            UserAccount valueObject = new UserAccount(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
