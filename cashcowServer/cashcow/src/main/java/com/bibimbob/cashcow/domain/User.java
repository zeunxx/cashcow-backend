package com.bibimbob.cashcow.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="User")
@Getter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="user_id")
    private String userId;

    private LocalDate birth;

    private String password;

    private String name;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private GENDER gender;

    private String job;

    @Enumerated(EnumType.STRING)
    private STATUS status;

    @Column (name="created_at")
    private LocalDateTime createdAt;

    @Column (name="modified_at")
    private LocalDateTime modifiedAt;

    @Column (name="phone_number")
    private String phoneNumber;

    private Long salary;



    //== 생성자 ==//
    public User( String userId, LocalDate birth, String password, String name, String nickname, GENDER gender, String job, STATUS status,LocalDateTime createdAt, LocalDateTime modifiedAt, String phoneNumber, long salary) {
        this.userId = userId;
        this.birth = birth;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.job = job;
        this.status = status;
        this.modifiedAt = modifiedAt;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    //== 유저 정보 변경 ==// (setter 대신, 유저 PK와 id 변경 불가)
    public void change(LocalDate birth, String password, String name, String nickname, GENDER gender, String job, STATUS status, LocalDateTime modifiedAt, String phoneNumber, Long salary) {
        this.birth = birth;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.job = job;
        this.status = status;
        this.modifiedAt = modifiedAt;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
