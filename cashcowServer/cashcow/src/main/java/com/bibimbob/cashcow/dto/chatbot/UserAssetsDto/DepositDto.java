package com.bibimbob.cashcow.dto.chatbot.UserAssetsDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "유저 자산 예금 정보", description = "유저 자산 예금 정보를 가진 Domain Class")
public class DepositDto extends UserAssetsDto{

    @ApiModelProperty(value = "유저 PK")
    private Long id;
    public DepositDto(Long expectedPeriod, Long savingAmount, long id) {
        super(expectedPeriod, savingAmount);
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
