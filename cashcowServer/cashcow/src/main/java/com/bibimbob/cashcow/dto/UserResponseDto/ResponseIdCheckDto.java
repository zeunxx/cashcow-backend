package com.bibimbob.cashcow.dto.UserResponseDto;

import lombok.Getter;

@Getter
public class ResponseIdCheckDto {
    private int result;

    public ResponseIdCheckDto(int result) {
        this.result = result;
    }
}
