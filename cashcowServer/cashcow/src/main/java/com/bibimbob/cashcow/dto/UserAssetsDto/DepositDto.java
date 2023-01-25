package com.bibimbob.cashcow.dto.UserAssetsDto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(value = "유저 자산 예금 정보", description = "유저 자산 예금 정보를 가진 Domain Class")
public class DepositDto extends UserAssetsDto{
    public DepositDto(Long expectedPeriod, Long savingAmount) {
        super(expectedPeriod, savingAmount);
    }
}
