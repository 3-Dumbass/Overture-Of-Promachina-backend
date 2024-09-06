package com.oops.OvertureOfPromachina.application.entity.user.valueObject;

import jakarta.persistence.Column;

import java.util.Objects;

public class UserPassword {

    @Column(nullable = false)
    private String password;

    public UserPassword(String password) {
        checkValid(password);
        this.password = password;
    }

    private void checkValid(String value){
        if (value==null){
            throw new IllegalArgumentException("패스워드는 null이 될 수 없습니다");
        }
        if(!value.isBlank()){
            throw new IllegalArgumentException("허용되지 않는 패스워드 형식입니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPassword that = (UserPassword) o;
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}
