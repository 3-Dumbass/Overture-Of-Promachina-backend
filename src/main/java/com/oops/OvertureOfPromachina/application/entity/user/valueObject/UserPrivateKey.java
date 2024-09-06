package com.oops.OvertureOfPromachina.application.entity.user.valueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserPrivateKey {
    @Column(nullable = false)
    private String privateKey;

    public UserPrivateKey(String privateKey) {
        checkValid(privateKey);
        this.privateKey = privateKey;
    }

    private void checkValid(String value){
        if (value==null){
            throw new IllegalArgumentException("개인키 null이 될 수 없습니다");
        }
        if(value.isBlank()){
            throw new IllegalArgumentException("허용되지 않는 개인키 형식입니다");
        }
    }
}
