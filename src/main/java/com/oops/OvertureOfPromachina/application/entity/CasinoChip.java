package com.oops.OvertureOfPromachina.application.entity;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * user_id, log_date, content, platform_id*/
public class CasinoChip {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account",nullable = true)
    private User account;

    @JoinColumn(name = "chip1", nullable = true)
    private long chip1_count;

    @JoinColumn(name = "chip2", nullable = true)
    private long chip2_count;

    @JoinColumn(name = "chip3", nullable = true)
    private long chip3_count;
}
