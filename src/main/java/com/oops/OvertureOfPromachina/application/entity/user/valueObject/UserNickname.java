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
public class UserNickname {
    @Column(unique = true, nullable = false)
    private String nickname;

    public UserNickname(String nickname) {
        checkValid(nickname);
        this.nickname = nickname;
    }

    private void checkValid(String nickname){

        String pattern = "^[0-9가-힣a-zA-Z]+";

        if (nickname==null){
            throw new IllegalArgumentException("닉네임은 null이 될 수 없습니다");
        }
        if(!nickname.matches(pattern)){
            throw new IllegalArgumentException("허용되지 않는 닉네임 형식입니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNickname that = (UserNickname) o;
        return Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }
}
