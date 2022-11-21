package com.bibimbob.cashcow.dto;

import com.bibimbob.cashcow.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String gender;
    @ApiModelProperty(value = "유저 직업")
    private String job;
    @ApiModelProperty(value = "유저 상태")
    private String status;
    @ApiModelProperty(value = "유저 정보 생성날짜")
    private String createdAt;
    @ApiModelProperty(value = "유저 정보 수정날짜")
    private String modifiedAt;
    @ApiModelProperty(value = "유저 핸드폰 번호")
    private String phoneNumber;
    @ApiModelProperty(value = "유저 오픈 뱅킹 접근위한 ACCESS TOKEN")
    private String accessToken;
    @ApiModelProperty(value = "유저 오픈뱅킹 REFRESH TOKEN ")
    private String refreshToken;
    @ApiModelProperty(value = "유저 오픈뱅킹 USER SEQ NO")
    private String userseqno;

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
        this.accessToken = user.getAccessToken();
        this.refreshToken = user.getRefreshToken();
        this.userseqno = user.getUserseqno();
    }
}
