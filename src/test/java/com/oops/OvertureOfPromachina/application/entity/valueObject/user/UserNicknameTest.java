package com.oops.OvertureOfPromachina.application.entity.valueObject.user;


import com.oops.OvertureOfPromachina.application.entity.user.valueObject.UserNickname;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserNicknameTest {
    @Test
    void formalTest1(){
        String value = "가ab456나";
        UserNickname valueObject = new UserNickname(value);
        Assertions.assertThat(valueObject.getNickname()).isEqualTo(value);
    }

    @Test
    void formalTest2(){
        String value = "123가ab456나";
        UserNickname valueObject = new UserNickname(value);
        Assertions.assertThat(valueObject.getNickname()).isEqualTo(value);
    }

    @Test
    void nullErrorTest(){
        String value = null;
        Assertions.assertThatThrownBy(() -> {
            UserNickname valueObject = new UserNickname(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyErrorTest(){
        String value = "";
        Assertions.assertThatThrownBy(() -> {
            UserNickname valueObject = new UserNickname(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void blankErrorTest(){
        String value = "   ";
        Assertions.assertThatThrownBy(() -> {
            UserNickname valueObject = new UserNickname(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matchErrorTest1(){
        String value = "가ab4 56나";
        Assertions.assertThatThrownBy(() -> {
            UserNickname valueObject = new UserNickname(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matchErrorTest2(){
        String value = "가ab45.6나";
        Assertions.assertThatThrownBy(() -> {
            UserNickname valueObject = new UserNickname(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matchErrorTest3(){
        String value = "#가ab456나";
        Assertions.assertThatThrownBy(() -> {
            UserNickname valueObject = new UserNickname(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matchErrorTest4(){
        String value = " 가ab456나";
        Assertions.assertThatThrownBy(() -> {
            UserNickname valueObject = new UserNickname(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
