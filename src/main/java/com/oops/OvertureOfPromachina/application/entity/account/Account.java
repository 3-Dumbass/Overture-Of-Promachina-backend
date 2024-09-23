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
    @JoinColumn(name = "user_id")
    private User user_id;

    @Column(name = "accountKey")
    private String accountKey;

    @Column(name = "priKey")
    private String priKey;


    public Account(User user_id, String accountKey, String priKey) {
        this.user_id = user_id;
        this.accountKey = accountKey;
        this.priKey = priKey;
    }
}
