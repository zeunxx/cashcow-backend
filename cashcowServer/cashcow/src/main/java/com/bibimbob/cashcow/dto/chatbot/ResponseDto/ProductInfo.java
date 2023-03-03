package com.bibimbob.cashcow.dto.chatbot.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductInfo {
    @JsonProperty("최고우대금리")
    private String bestInterestRate;
    @JsonProperty("저축금리")
    private String savingRate;
    @JsonProperty("저축기간")
    private String savingPeriod;
    @JsonProperty("적립유형명")
    private String accumulationTypeName;
    @JsonProperty("저축금리유형명")
    private String savingsRateTypeName;
    @JsonProperty("최고한도")
    private String maximumLimit;
    @JsonProperty("가입대상")
    private String subscriptionTarget;
    @JsonProperty("가입제한")
    private String subscriptionRestrictions;
    @JsonProperty("우대조건")
    private String preferentialConditions;
    @JsonProperty("만기후이자율")
    private String interestRateAfterMaturity;
    @JsonProperty("가입방법")
    private String route;
    @JsonProperty("금융상품명")
    private String financialProductName;
    @JsonProperty("금융회사명")
    private String financialCompanyName;
    @JsonProperty("공시제출월")
    private String noticeSubmissionMonth;


    public ProductInfo() {
    }
}
