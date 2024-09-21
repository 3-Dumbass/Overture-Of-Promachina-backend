package com.oops.OvertureOfPromachina.application.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long account_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account",nullable = true)
    private User account;

    @Column(name = "coin1")
    private long coin1_count;

    @Column(name = "coin2")
    private long coin2_count;

    @Column(name = "coin3")
    private long coin3_count;
}
