package com.bibimbob.cashcow.dto.openbanking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "계좌 잔액 정보", description = "계좌 잔액 정보를 가진 Domain Class")
public class AccountBalanceDto {
    @ApiModelProperty(value = "거래 고유 번호")
    private String api_tran_id; // 거래 고유 번호
    @ApiModelProperty(value = "거래일시")
    private String api_tran_dtm; // 거래일시
    @ApiModelProperty(value = "응답코드")
    private String rsp_code; // 응답코드
    @ApiModelProperty(value = "응답메시지")
    private String rsp_message; // 응답 메시지
    @ApiModelProperty(value = "거래 고유 번호")
    private String bank_tran_id; // 거래 고유 번호
    @ApiModelProperty(value = "거래 일자")
    private String bank_tran_date; // 거래 일자
    @ApiModelProperty(value = "응답 코드를 부여한 참가은행 표준 코드")
    private String bank_code_tran; // 응답 코드를 부여한 참가은행 표준 코드
    @ApiModelProperty(value = "응답 코드")
    private String bank_rsp_code; // 응답코드
    @ApiModelProperty(value = "응답 메시지")
    private String bank_rsp_message; // 응답 메시지
    @ApiModelProperty(value = "개설 기관명")
    private String bank_name; // 개설기관명
    @ApiModelProperty(value = "개별 저축 은행명")
    private String savings_bank_name; // 개별저축은행명
    @ApiModelProperty(value = "핀테크 이용번호")
    private String fintech_use_num; //핀테크 이용번호
    @ApiModelProperty(value = "계좌 잔액")
    private String balance_amt; // 계좌잔액
    @ApiModelProperty(value = "출금 가능 금액")
    private String available_amt; // 출금가능금액
    @ApiModelProperty(value = "계좌 종류(1:수시입출금, 2:예적금, 6:수익증권, T:종합계좌)")
    private String account_type; // 계좌종류 (1:수시입출금, 2:예적금, 6:수익증권, T:종합계좌)
    @ApiModelProperty(value = "상품명")
    private String product_name; //상품명
    @ApiModelProperty(value = "계좌 개설일")
    private String account_issue_date; //계좌개설일
    @ApiModelProperty(value = "만기일")
    private String maturity_date; // 만기일
    @ApiModelProperty(value = "최종 거래일")
    private String last_tran_date; // 최종거래일


}
