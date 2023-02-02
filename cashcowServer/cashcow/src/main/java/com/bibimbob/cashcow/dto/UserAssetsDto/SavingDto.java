package com.bibimbob.cashcow.dto.UserAssetsDto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "유저 자산 적금 정보", description = "유저 자산 적금 정보를 가진 Domain Class")
public class SavingDto extends UserAssetsDto{

    @ApiModelProperty(value = "유저 PK")
    private Long id;
    @ApiModelProperty(value = "월 저축 금액")
    private Long monthlyPayment;

    public SavingDto(Long expectedPeriod, Long savingAmount, Long monthlyPayment, long id) {
        super(expectedPeriod, savingAmount);
        this.monthlyPayment = monthlyPayment;
        this.id = id;
    }
}
