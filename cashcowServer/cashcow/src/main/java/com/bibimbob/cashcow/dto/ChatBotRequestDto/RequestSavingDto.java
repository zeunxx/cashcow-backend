package com.bibimbob.cashcow.dto.ChatBotRequestDto;

import com.bibimbob.cashcow.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestSavingDto {
    private Long expectedPeriod;
    private Long savingAmount;
    private Long monthlyPayment;
    private UserDto userDto;
}
