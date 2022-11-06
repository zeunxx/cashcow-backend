package com.bibimbob.cashcow.dto;

import lombok.Data;

@Data
public class AccountBalanceDto {
    private String api_tran_id; // 거래 고유 번호
    private String api_tran_dtm; // 거래일시
    private String rsp_code; // 응답코드
    private String rsp_message; // 응답 메시지
    private String bank_tran_id; // 거래 고유 번호
    private String bank_tran_date; // 거래 일자
    private String bank_code_tran; // 응답 코드를 부여한 참가은행 표준 코드
    private String bank_rsp_code; // 응답코드
    private String bank_rsp_message; // 응답 메시지
    private String bank_name; // 개설기관명
    private String savings_bank_name; // 개별저축은행명
    private String fintech_use_num; //핀테크 이용번호
    private String balance_amt; // 계좌잔액
    private String available_amt; // 출금가능금액
    private String account_type; // 계좌종류 (1:수시입출금, 2:예적금, 6:수익증권, T:종합계좌)
    private String product_name; //상품명
    private String account_issue_date; //계좌개설일
    private String maturity_date; // 만기일
    private String last_tran_date; // 최종거래일


}
