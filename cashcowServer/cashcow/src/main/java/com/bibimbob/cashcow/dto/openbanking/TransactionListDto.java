package com.bibimbob.cashcow.dto.openbanking;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class TransactionListDto {

    @ApiModelProperty(value = "거래 고유 번호")
    private String api_tran_id; // 거래 고유 번호
    @ApiModelProperty(value = "응답코드")
    private String rsp_code; // 응답코드
    @ApiModelProperty(value = "응답메시지")
    private String rsp_message; // 응답 메시지
    @ApiModelProperty(value = "거래 일시")
    private String api_tran_dtm;
    @ApiModelProperty(value = "거래 고유 번호")
    private String bank_tran_id; // 거래 고유 번호
    @ApiModelProperty(value = "거래 일자")
    private String bank_tran_date; // 거래 일자
    @ApiModelProperty(value = "응답 코드를 부여한 참가은행 표준 코드")
    private String bank_code_tran; // 응답 코드를 부여한 참가은행 표준 코드
    @ApiModelProperty(value = "응답코드")
    private String bank_rsp_code; // 응답코드
    @ApiModelProperty(value = "응답메시지")
    private String bank_rsp_message; // 응답 메시지
    @ApiModelProperty(value = "핀테크 이용번호")
    private String fintech_use_num; //핀테크 이용번호
    @ApiModelProperty(value = "계좌 잔액")
    private String balance_amt; // 계좌잔액
    @ApiModelProperty(value = "현재페이지 레코드 건수")
    private String page_record_cnt; // 현재페이지 레코드 건수
    @ApiModelProperty(value = "다음페이지 존재여부")
    private String next_page_yn; // 다음페이지 존재여부
    @ApiModelProperty(value = "직전 조회추적 정보")
    private String befor_inquiry_trace_info; //직전 조회추적 정보
    @ApiModelProperty(value = "개설기관명")
    private String bank_name; // 개설기관명
    @ApiModelProperty(value = "개별저축은행명")
    private String savings_bank_name;
    @ApiModelProperty(value = "조회된 거래 내역 list")
    private List<TransactionDto> res_list;
}
