package com.bibimbob.cashcow.dto.User.UserRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPwMatchDto {
    private String userId;
    private String userPass;
}
