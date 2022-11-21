package com.bibimbob.cashcow.dto.openbanking;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "토큰 요청에 대한 응답 정보", description = "토큰 응답 정보를 가진 Domain Class")
public class TokenResponseDto {

    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String scope;
    private String user_seq_no;
}