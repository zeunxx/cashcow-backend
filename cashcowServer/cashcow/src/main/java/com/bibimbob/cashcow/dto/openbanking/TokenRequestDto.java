package com.bibimbob.cashcow.dto.openbanking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "토큰 요청 정보", description = "토큰 요청 정보를 가진 Domain Class")
public class TokenRequestDto {
    @ApiModelProperty(value = "코드")
    private String code;
    @ApiModelProperty(value = "금융거래원 clinet id")
    private String client_id;
    @ApiModelProperty(value = "금융거래원 client secret")
    private String client_secret;
    @ApiModelProperty(value = "등록한 redirect uri")
    private String redirect_uri;
    @ApiModelProperty(value = "0/2")
    private String grant_type;
}