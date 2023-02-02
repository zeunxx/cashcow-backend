package com.bibimbob.cashcow.dto.UserAssetsDto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(value = "유저 자산 대출 정보", description = "유저 자산 대출 정보를 가진 Domain Class")
public class LoanDto {
    private long id; // 유저 PK
    private int num; // 유저 신용 점수?
}
