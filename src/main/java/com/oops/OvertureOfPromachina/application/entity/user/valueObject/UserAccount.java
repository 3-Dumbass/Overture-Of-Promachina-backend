package com.oops.OvertureOfPromachina.application.entity.user.valueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserAccount {

    @Column(nullable = false)
    private String account;

    public UserAccount(String account) {
        checkValid(account);
        this.account = account;
    }

    private void checkValid(String value){
        if (value==null){
            throw new IllegalArgumentException("유저 계정은 null이 될 수 없습니다");
        }
        if(value.isBlank()){
            throw new IllegalArgumentException("허용되지 않는 유저 계정 형식입니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }
}
