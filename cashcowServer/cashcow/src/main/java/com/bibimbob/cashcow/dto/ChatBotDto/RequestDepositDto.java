package com.bibimbob.cashcow.dto.ChatBotDto;

import com.bibimbob.cashcow.dto.UserDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDepositDto {
    private Long expectedPeriod;
    private Long savingAmount;
    private UserDto userDto;
}
