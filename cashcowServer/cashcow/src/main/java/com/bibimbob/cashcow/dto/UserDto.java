package com.bibimbob.cashcow.dto;

import com.bibimbob.cashcow.domain.GENDER;
import com.bibimbob.cashcow.domain.User;
import com.bibimbob.cashcow.domain.UserAssets;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ApiModel(value = "유저 정보", description = "유저 정보를 가진 Domain Class")
public class UserDto {
    @ApiModelProperty(value = "유저 코드")
    private long id;
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
    private String status;
    @ApiModelProperty(value = "유저 정보 생성날짜")
    private LocalDateTime createdAt;
    @ApiModelProperty(value = "유저 정보 수정날짜")
    private LocalDateTime modifiedAt;
    @ApiModelProperty(value = "유저 핸드폰 번호")
    private String phoneNumber;

    private UserAssets userAsset;


    //== 생성 메소드==//
    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.gender = user.getGender();
        this.job = user.getJob();
        this.status = user.getStatus();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
        this.phoneNumber = user.getPhoneNumber();
        this.userAsset = user.getUserAsset();
    }

    public UserDto(String name, String password, String nickname, GENDER gender, String job, String status, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.job = job;
        this.status = status;
        this.phoneNumber = phoneNumber;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .password(password)
                .nickname(nickname)
                .gender(gender)
                .job(job)
                .status(status)
                .phoneNumber(phoneNumber)
                .userAsset(userAsset)
                .build();
    }
}
