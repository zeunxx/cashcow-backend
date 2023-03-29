package com.bibimbob.cashcow.domain;


import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="User")
@Getter
public class User extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="user_id",updatable = false)
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

    @Column (name="phone_number")
    private String phoneNumber;

    private Long salary;



    //== 생성자 ==//
    public User( String userId, LocalDate birth, String password, String name, String nickname, GENDER gender, String job, STATUS status, String phoneNumber, long salary) {
        this.userId = userId;
        this.birth = birth;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.job = job;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    //== 유저 정보 변경 ==// (setter 대신, 유저 PK와 id 변경 불가)
    public void changePassword(String password) {
        this.password = password;

    }
    public void change(LocalDate birth, String name, String nickname, GENDER gender, String job, STATUS status, String phoneNumber, Long salary) {
        this.birth = birth;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.job = job;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    /**
     * 비밀번호 암호화
     */
    public String passwordEncode(String password, PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
        return this.password;
    }

    @Override
    public String toString() {
        return "User{" +
                " 이름 = " + this.name +
                ", 비밀번호 = " + this.password +
                '}';
    }

}
