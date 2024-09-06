package com.oops.OvertureOfPromachina.application.entity.valueObject.user;

import com.oops.OvertureOfPromachina.application.entity.user.valueObject.UserPrivateKey;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserPrivateKeyTest {
    @Test
    void formalTest1(){
        String value = "ab456";
        UserPrivateKey valueObject = new UserPrivateKey(value);
        Assertions.assertThat(valueObject.getPrivateKey()).isEqualTo(value);
    }

    @Test
    void formalTest2(){
        String value = "ab456dnh";
        UserPrivateKey valueObject = new UserPrivateKey(value);
        Assertions.assertThat(valueObject.getPrivateKey()).isEqualTo(value);
    }

    @Test
    void nullErrorTest(){
        String value = null;
        Assertions.assertThatThrownBy(() -> {
            UserPrivateKey valueObject = new UserPrivateKey(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyErrorTest(){
        String value = "";
        Assertions.assertThatThrownBy(() -> {
            UserPrivateKey valueObject = new UserPrivateKey(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void blankErrorTest(){
        String value = "   ";
        Assertions.assertThatThrownBy(() -> {
            UserPrivateKey valueObject = new UserPrivateKey(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
