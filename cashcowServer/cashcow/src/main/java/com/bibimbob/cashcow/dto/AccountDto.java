package com.bibimbob.cashcow.dto;

import lombok.Data;

@Data
public class AccountDto {
    private String fintech_use_num; // 핀테크이용번호
    private String account_alias; // 계좌별명
    private String bank_code_std; // 개설 기관 대표코드
    private String bank_code_sub; // 개설 기관 개별 코드
    private String bank_name; // 개설 기관명 ex 오픈은행
    private String savings_bank_name; // 개별 저축 은행명 ex 오픈저축은행
    private String account_num; // 계좌번호
    private String account_num_masked; // 마스킹된 출력용 계좌
    private String account_holder_name; // 계좌예금주명
    private String account_holder_type; // 계좌 구분 (P:개인)
    private String account_type; // 계좌종류 (1:수시입출금, 2:예적금, 6:수익증권, T:종합계좌)
    private String inquiry_agree_yn; //조회서비스 동의여부
    private String inquiry_agree_dtime; // 조회서비스 동의일시
    private String transfer_agree_yn; // 출금서비스 동의여부
    private String transfer_agree_dtime; // 출금서비스 동의일시
    private String account_state; // 계좌상태 (01:사용, 09:해지)

}
