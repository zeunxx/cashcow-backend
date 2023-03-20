package com.bibimbob.cashcow.dto.chatbot.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanProductInfo {

    @JsonProperty("평균 금리")
    private String averageInterestRate;//평균 금리;

    @JsonProperty("300점 이하")
    private String less300;//300점 이하;
    @JsonProperty("301~400점")
    private String less400;//301~400점;
    @JsonProperty("401~500점")
    private String less500;//401~500점;
    @JsonProperty("501~600점")
    private String less600;//501~600점;
    @JsonProperty("601~700점")
    private String less700;//601~700점;
    @JsonProperty("701~800점")
    private String less800;//701~800점;
    @JsonProperty("801~900점")
    private String less900;//801~900점;
    @JsonProperty("900점초과")
    private String less1000;//900점초과;
    @JsonProperty("금리구분")
    private String classInterestRate;
    @JsonProperty("금리구분코드")
    private String classInterestRateCode;
    @JsonProperty("금융회사제출일")
    private String submissionDate;
    @JsonProperty("공시종료일")
    private String endDate;
    @JsonProperty("공시시작일")
    private String startDate;
    @JsonProperty("CB회사명")
    private String CreditBureauName;
    @JsonProperty("대출종류명")
    private String loanType;
    @JsonProperty("대출종류코드")
    private String loanTypeCode;
    @JsonProperty("가입방법")
    private String route;
    @JsonProperty("금융상품명")
    private String financialProductName;
    @JsonProperty("금융상품코드")
    private String financialProductCode;
    @JsonProperty("금융회사명")
    private String financialCompanyName;
    @JsonProperty("금융회사코드")
    private String financialCompanyCode;
    @JsonProperty("공시제출월")
    private String noticeSubmissionMonth;
}
