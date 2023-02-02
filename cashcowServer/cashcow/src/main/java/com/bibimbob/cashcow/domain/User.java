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
@Getter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="user_id", nullable = false)
    private String userId;

    @Column (nullable = false)
    private LocalDate birth;

    @Column (nullable = false)
    private String password;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String nickname;

    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private GENDER gender;

    @Column (nullable = false)
    private String job;

    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private STATUS status;

    @Column (name="created_at")
    private LocalDateTime createdAt;

    @Column (name="modified_at")
    private LocalDateTime modifiedAt;

    @Column (nullable = false,name="phone_number")
    private String phoneNumber;

    @Column (nullable = false)
    private Long salary;



    //== 생성 메소드 ==//

    public User( String userId, LocalDate birth, String password, String name, String nickname, GENDER gender, String job, STATUS status, LocalDateTime modifiedAt, String phoneNumber, long salary) {
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

    //== 유저 정보 변경 ==// (setter 대신)
    public void change(String userId, LocalDate birth, String password, String name, String nickname, GENDER gender, String job, STATUS status, LocalDateTime modifiedAt, String phoneNumber, Long salary) {
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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
