package com.bibimbob.cashcow.dto.ChatBotRequestDto;

import com.bibimbob.cashcow.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestLoanDto {
    private int num; // 신용점수?
    private UserDto userDto;
}
