package com.bibimbob.cashcow.dto.openbanking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "거래 정보", description = "거래 정보를 가진 Domain Class")
public class TransactionDto {
    @ApiModelProperty(value = "거래일자")
    private String tran_date; // 거래일자
    @ApiModelProperty(value = "거래시간")
    private String tran_time; //거래시간
    @ApiModelProperty(value = "입출금 구분")
    private String inout_type; // 입출금구분
    @ApiModelProperty(value = "거래구분")
    private String tran_type; // 거래구분
    @ApiModelProperty(value = "통장인자내용")
    private String print_content; // 통장인자내용
    @ApiModelProperty(value = "거래 금액")
    private String tran_amt; //거래금액
    @ApiModelProperty(value = "거래 후 잔액")
    private String after_balance_amt; //거래후 잔액
    @ApiModelProperty(value = "거래점명")
    private String branch_name; //거래점명
}
