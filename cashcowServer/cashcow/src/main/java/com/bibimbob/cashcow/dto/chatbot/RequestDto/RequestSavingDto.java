package com.bibimbob.cashcow.dto.chatbot.RequestDto;

import com.bibimbob.cashcow.dto.UserDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestSavingDto {
    private Long expectedPeriod;
    private Long savingAmount;
    private Long monthlyPayment;
    private UserDto userDto;
}
