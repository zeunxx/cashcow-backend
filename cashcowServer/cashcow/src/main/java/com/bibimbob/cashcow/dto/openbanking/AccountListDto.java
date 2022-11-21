package com.bibimbob.cashcow.dto.openbanking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "계좌 리스트 정보", description = "계좌 정보 리스트를 가진 Domain Class")
public class AccountListDto {
    @ApiModelProperty(value = "거래 고유 번호")
    private String api_tran_id; // 거래 고유 번호
    @ApiModelProperty(value = "거래일시")
    private String api_tran_dtm; // 거래일시
    @ApiModelProperty(value = "응답코드")
    private String rsp_code; // 응답코드
    @ApiModelProperty(value = "응답메시지")
    private String rsp_message; // 응답메시지
    @ApiModelProperty(value = "사용자명")
    private String user_name; // 사용자명
    @ApiModelProperty(value = "사용자 등록계좌 개수")
    private String res_cnt; // 사용자 등록계좌 개수
    @ApiModelProperty(value = "사용자 등록계좌 리스트")
    private List<AccountDto> res_list; //사용자 등록계좌 리스트
}
