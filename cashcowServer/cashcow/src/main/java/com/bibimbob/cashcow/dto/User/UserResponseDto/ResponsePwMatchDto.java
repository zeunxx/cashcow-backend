package com.bibimbob.cashcow.dto.User.UserResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePwMatchDto {
    private boolean userResult; // user result 값 false : 없는 회원 / true : 있는 회원
    private long pk;
    private boolean matchResult; // match Result
}
