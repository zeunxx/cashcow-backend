package com.bibimbob.cashcow.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Table(name="user")
@Getter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false)
    private String password;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String nickname;

    @Column (nullable = false)
    private String gender;

    @Column (nullable = false)
    private String job;

    @Column (nullable = false)
    private String status;

    @Column (nullable = false)
    private String createdAt;

    @Column (nullable = false)
    private String modifiedAt;

    @Column (nullable = false)
    private String phoneNumber;

    @Column (nullable = false)
    private String accessToken;

    @Column (nullable = false)
    private String refreshToken;

    @Column (nullable = false)
    private String userseqno;


    @Builder
    public User(long id, String password, String name, String nickname, String gender, String job, String status, String createdAt, String modifiedAt, String phoneNumber, String accessToken, String refreshToken, String userseqno) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.job = job;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.phoneNumber = phoneNumber;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userseqno = userseqno;
    }

}
