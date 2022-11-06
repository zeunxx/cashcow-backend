package com.bibimbob.cashcow.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountListDto {
    private String api_tran_id; // 거래 고유 번호
    private String api_tran_dtm; // 거래일시
    private String rsp_code; // 응답코드
    private String rsp_message; // 응답메시지
    private String user_name; // 사용자명
    private String res_cnt; // 사용자 등록계좌 개수
    private List<AccountDto> res_list; //사용자 등록계좌 리스트
}
