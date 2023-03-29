package com.bibimbob.cashcow.dto.User.UserResponseDto;

import lombok.Getter;

@Getter
public class ResponseCheckDto {
    private int result;

    public ResponseCheckDto(int result) {
        this.result = result;
    }
}
