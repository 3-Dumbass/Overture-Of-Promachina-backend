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
    @JoinColumn(name = "account")
    private User account;

    @Column(name = "coin_name")
    private String coin_name;

    @Column(name = "coin_count")
    private long coin_count;

}
