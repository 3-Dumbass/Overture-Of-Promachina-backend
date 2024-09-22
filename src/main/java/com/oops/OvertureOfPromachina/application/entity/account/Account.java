package com.oops.OvertureOfPromachina.application.entity.account;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    @GeneratedValue
    private long account_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loginId")
    private User loginId;

    @Column(name = "account")
    private String account;


    public Account(User loginId, String account) {
        this.loginId = loginId;
        this.account = account;
    }
}
