package com.oops.OvertureOfPromachina.application.entity.user.valueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserLoginId {

    @Column(unique = true, nullable = false)
    private String loginId;

    public UserLoginId(String loginId) {
        checkValid(loginId);
        this.loginId = loginId;
    }

    private void checkValid(String loginId){

        String pattern = "^[a-zA-Z]+[0-9a-zA-Z]+";

        if (loginId==null){
            throw new IllegalArgumentException("아이디는 null이 될 수 없습니다");
        }
        if(!loginId.matches(pattern)){
            throw new IllegalArgumentException("허용되지 않는 아이디 형식입니다");
        }
    }
}
