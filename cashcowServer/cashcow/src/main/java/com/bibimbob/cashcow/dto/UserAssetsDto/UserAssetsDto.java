package com.bibimbob.cashcow.dto.UserAssetsDto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(value = "유저 자산 정보", description = "유저 자산 정보를 가진 Domain Class")
public abstract class UserAssetsDto {

    @ApiModelProperty(value = "저축 예상 기간")
    private Long expectedPeriod;
    @ApiModelProperty(value = "총 저축 금액")
    private Long savingAmount;

    public UserAssetsDto(Long expectedPeriod, Long savingAmount) {
        this.expectedPeriod = expectedPeriod;
        this.savingAmount = savingAmount;
    }

    @Override
    public String toString() {
        return "UserAssetsDto{" +
                "expectedPeriod=" + expectedPeriod +
                ", savingAmount=" + savingAmount +
                '}';
    }
}
