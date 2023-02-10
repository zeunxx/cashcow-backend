package com.bibimbob.cashcow.dto.ChatBotResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanProductInfo {

    @JsonProperty("평균 금리")
    private String 평균금리;//평균 금리;

    @JsonProperty("300점 이하")
    private String 신용_300점;//300점 이하;
    @JsonProperty("301~400점")
    private String 신용_301_400점;//301~400점;
    @JsonProperty("401~500점")
    private String 신용_401_500점;//401~500점;
    @JsonProperty("501~600점")
    private String 신용_501_600점;//501~600점;
    @JsonProperty("601~700점")
    private String 신용_601_700점;//601~700점;
    @JsonProperty("701~800점")
    private String 신용_701_800점;//701~800점;
    @JsonProperty("801~900점")
    private String 신용_801_900점;//801~900점;
    @JsonProperty("900점초과")
    private String 신용_900점;//900점초과;
    @JsonProperty("금리구분")
    private String 금리구분;
    @JsonProperty("금리구분코드")
    private String 금리구분코드;
    @JsonProperty("금융회사제출일")
    private String 금융회사제출일;
    @JsonProperty("공시종료일")
    private String 공시종료일;
    @JsonProperty("공시시작일")
    private String 공시시작일;
    @JsonProperty("CB회사명")
    private String cb회사명;
    @JsonProperty("대출종류명")
    private String 대출종류명;
    @JsonProperty("대출종류코드")
    private String 대출종류코드;
    @JsonProperty("가입방법")
    private String 가입방법;
    @JsonProperty("금융상품명")
    private String 금융상품명;
    @JsonProperty("금융상품코드")
    private String 금융상품코드;
    @JsonProperty("금융회사명")
    private String 금융회사명;
    @JsonProperty("금융회사코드")
    private String 금융회사코드;
    @JsonProperty("공시제출월")
    private String 공시제출월;
}
