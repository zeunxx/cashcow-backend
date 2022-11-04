package com.bibimbob.cashcow.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private long id;
    private String name;
    private String password;
    private String nickname;
    private String gender;
    private String job;
    private String status;
    private String createdAt;
    private String modifiedAt;
    private String phoneNumber;
    private String accessToken;
    private String refreshToken;
    private String userseqno;

}
