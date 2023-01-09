package com.bibimbob.cashcow.domain;

import com.bibimbob.cashcow.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="User")
@Getter
//@DynamicInsert // insert시 null값 제외하고 DB INSERT
//@DynamicUpdate // update시 null값 제외하고 DB UPDATE
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="user_id")
    private long id;

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
    private String status;

    @Column (name="created_at")
    private LocalDateTime createdAt;

    @Column (name="modified_at")
    private LocalDateTime modifiedAt;

    @Column (nullable = false,name="phone_number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_assets_id")
    private UserAssets userAsset;


    //== 생성 메소드 ==//
    @Builder
    public User(String password, String name, String nickname, GENDER gender, String job, String status, LocalDateTime createdAt, LocalDateTime modifiedAt, String phoneNumber,UserAssets userAsset) {
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.job = job;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.phoneNumber = phoneNumber;
        this.userAsset = userAsset;
    }

    //== 유저 정보 변경 ==// (setter 대신)
    public void change(String password, String name, String nickname, GENDER gender, String job, String status, LocalDateTime modifiedAt, String phoneNumber) {
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.job = job;
        this.status = status;
        this.modifiedAt = modifiedAt;
        this.phoneNumber = phoneNumber;
    }
}
