package com.bibimbob.cashcow.dto.chatbot.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLoanProductInfo {

    private String averageInterestRate;//평균 금리;
    private String less300;//300점 이하;
    private String less400;//301~400점;
    private String less500;//401~500점;
    private String less600;//501~600점;
    private String less700;//601~700점;
    private String less800;//701~800점;
    private String less900;//801~900점;
    private String less1000;//900점초과;
    private String classInterestRate;
    private String classInterestRateCode;
    private String submissionDate;
    private String endDate;
    private String startDate;
    private String CreditBureauName;
    private String loanType;
    private String loanTypeCode;
    private String route;
    private String financialProductName;
    private String financialProductCode;
    private String financialCompanyName;
    private String financialCompanyCode;
    private String noticeSubmissionMonth;

    public ResponseLoanProductInfo(LoanProductInfo pi) {
        this.averageInterestRate = pi.getAverageInterestRate();
        this.less300 = pi.getLess300();
        this.less400 = pi.getLess400();
        this.less500 = pi.getLess500();
        this.less600 = pi.getLess600();
        this.less700 = pi.getLess700();
        this.less800 = pi.getLess800();
        this.less900 = pi.getLess900();
        this.less1000 = pi.getLess1000();
        this.classInterestRate = pi.getClassInterestRate();
        this.classInterestRateCode = pi.getClassInterestRateCode();
        this.submissionDate = pi.getSubmissionDate();
        this.endDate = pi.getEndDate();
        this.startDate = pi.getStartDate();
        this.CreditBureauName = pi.getCreditBureauName();
        this.loanType = pi.getLoanType();
        this.loanTypeCode = pi.getLoanTypeCode();
        this.route = pi.getRoute();
        this.financialProductName = pi.getFinancialProductName();
        this.financialProductCode = pi.getFinancialProductCode();
        this.financialCompanyName = pi.getFinancialCompanyName();
        this.financialCompanyCode = pi.getFinancialCompanyCode();
        this.noticeSubmissionMonth = pi.getNoticeSubmissionMonth();
    }
}
