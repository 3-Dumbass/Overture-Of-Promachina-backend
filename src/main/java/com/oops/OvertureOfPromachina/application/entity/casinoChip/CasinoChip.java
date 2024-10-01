package com.oops.OvertureOfPromachina.application.entity.casinoChip;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * user_id, money*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CasinoChip {

    @Id
    @GeneratedValue
    private Long casino_chip_id;

    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user_id;

    @Column(name = "money")
    private Long money;


    public CasinoChip(User user, Long money) {
        this.user_id = user;
        this.money = money;
    }

}
