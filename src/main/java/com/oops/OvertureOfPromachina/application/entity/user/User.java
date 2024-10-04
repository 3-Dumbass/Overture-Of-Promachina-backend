package com.oops.OvertureOfPromachina.application.entity.user;

import com.oops.OvertureOfPromachina.application.entity.user.valueObject.*;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Embedded
    private UserNickname nickname;

    @Embedded
    private UserLoginId loginId;

    @Embedded
    private UserPassword pwd;

    @Column(name = "user_image_url")
    private String userImageUrl;

    public User(String  nickname, String  loginId, String  pwd, String userImageUrl) {
        this.nickname = new UserNickname(nickname);
        this.loginId = new UserLoginId(loginId);
        this.pwd = new UserPassword(pwd);
        this.userImageUrl = userImageUrl;
    }
}
