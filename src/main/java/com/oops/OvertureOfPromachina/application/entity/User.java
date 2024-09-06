package com.oops.OvertureOfPromachina.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @Column(name = "nick_name")
    private String nick_name;

    @Id
    @Column(name = "user_id")
    private String user_id;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "accout")
    private String accout;

    @Column(name = "pri_key")
    private String pri_key;
}
