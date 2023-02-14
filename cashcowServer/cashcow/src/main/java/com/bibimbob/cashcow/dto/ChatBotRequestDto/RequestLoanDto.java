package com.bibimbob.cashcow.dto.ChatBotRequestDto;

import com.bibimbob.cashcow.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestLoanDto {
    private int creditScore; // 유저 신용 점수
    private long loanAmount;
    private UserDto userDto;
}
