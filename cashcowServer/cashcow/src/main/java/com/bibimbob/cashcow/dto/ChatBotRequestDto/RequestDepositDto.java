package com.bibimbob.cashcow.dto.ChatBotRequestDto;

import com.bibimbob.cashcow.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDepositDto {
    private Long expectedPeriod;
    private Long savingAmount;
    private UserDto userDto;

    @Override
    public String toString() {
        return "RequestDepositDto{" +
                "expectedPeriod=" + expectedPeriod +
                ", savingAmount=" + savingAmount +
                ", userDto=" + userDto +
                '}';
    }
}
