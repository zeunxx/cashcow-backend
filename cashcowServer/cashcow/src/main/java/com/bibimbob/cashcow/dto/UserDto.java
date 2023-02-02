package com.bibimbob.cashcow.dto;

import com.bibimbob.cashcow.domain.GENDER;
import com.bibimbob.cashcow.domain.STATUS;
import com.bibimbob.cashcow.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@ApiModel(value = "유저 정보", description = "유저 정보를 가진 Domain Class")
public class UserDto {
    @ApiModelProperty(value = "유저 코드")
    private long id;

    @ApiModelProperty(value = "유저 아이디")
    private String userId;
    @ApiModelProperty(value = "유저 이름")
    private String name;
    @ApiModelProperty(value = "유저 비밀번호")
    private String password;
    @ApiModelProperty(value = "유저 닉네임")
    private String nickname;
    @ApiModelProperty(value = "유저 성별")
    private GENDER gender;
    @ApiModelProperty(value = "유저 직업")
    private String job;
    @ApiModelProperty(value = "유저 상태")
    private STATUS status;
    @ApiModelProperty(value = "유저 정보 생성날짜")
    private LocalDateTime createdAt;
    @ApiModelProperty(value = "유저 정보 수정날짜")
    private LocalDateTime modifiedAt;
    @ApiModelProperty(value = "유저 핸드폰 번호")
    private String phoneNumber;
    @ApiModelProperty(value = "유저 생년월일")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    private LocalDate birth;
    @ApiModelProperty(value = "유저 연봉")
    private Long salary;

//    private UserAssets userAsset;


    //== 생성 메소드==//
    public UserDto(User user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.birth = user.getBirth();
        this.name = user.getName();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.gender = user.getGender();
        this.job = user.getJob();
        this.status = user.getStatus();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
        this.phoneNumber = user.getPhoneNumber();
        this.salary = user.getSalary();

    }

    public UserDto(String userId, String name, String password, String nickname, GENDER gender, String job, STATUS status, LocalDateTime modifiedAt, String phoneNumber, LocalDate birth, long salary) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.job = job;
        this.status = status;
        this.modifiedAt = modifiedAt;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.salary = salary;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public User toEntity(){
        return new User(userId, birth, password, name, nickname, gender, job, status, modifiedAt, phoneNumber, salary);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", job='" + job + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birth=" + birth +
                ", salary=" + salary +
                '}';
    }
}
