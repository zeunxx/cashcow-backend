package com.bibimbob.cashcow.dto.ChatBotResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class ProductInfo {
    @JsonProperty("최고우대금리")
    private String 최고우대금리;
    @JsonProperty("저축금리")
    private String 저축금리;
    @JsonProperty("저축기간")
    private String 저축기간;
    @JsonProperty("적립유형명")
    private String 적립유형명;
    @JsonProperty("저축금리유형명")
    private String 저축금리유형명;
    @JsonProperty("최고한도")
    private String 최고한도;
    @JsonProperty("가입대상")
    private String 가입대상;
    @JsonProperty("가입제한")
    private String 가입제한;
    @JsonProperty("우대조건")
    private String 우대조건;
    @JsonProperty("만기후이자율")
    private String 만기후이자율;
    @JsonProperty("가입방법")
    private String 가입방법;
    @JsonProperty("금융상품명")
    private String 금융상품명;
    @JsonProperty("금융회사명")
    private String 금융회사명;
    @JsonProperty("공시제출월")
    private String 공시제출월;

    @Override
    public String toString() {
        return "ProductInfo{" +
                "최고우대금리='" + 최고우대금리 + '\'' +
                ", 저축금리='" + 저축금리 + '\'' +
                ", 저축기간='" + 저축기간 + '\'' +
                ", 적립유형명='" + 적립유형명 + '\'' +
                ", 저축금리유형명='" + 저축금리유형명 + '\'' +
                ", 최고한도='" + 최고한도 + '\'' +
                ", 가입대상='" + 가입대상 + '\'' +
                ", 가입제한='" + 가입제한 + '\'' +
                ", 우대조건='" + 우대조건 + '\'' +
                ", 만기후이자율='" + 만기후이자율 + '\'' +
                ", 가입방법='" + 가입방법 + '\'' +
                ", 금융상품명='" + 금융상품명 + '\'' +
                ", 금융회사명='" + 금융회사명 + '\'' +
                ", 공시제출월='" + 공시제출월 + '\'' +
                '}';
    }

    public ProductInfo() {
    }
}
