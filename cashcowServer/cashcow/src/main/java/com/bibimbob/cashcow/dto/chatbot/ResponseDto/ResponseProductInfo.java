package com.bibimbob.cashcow.dto.chatbot.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductInfo {

    private String bestInterestRate;
    private String savingRate;
    private String savingPeriod;
    private String accumulationTypeName;
    private String savingsRateTypeName;
    private String maximumLimit;
    private String subscriptionTarget;
    private String subscriptionRestrictions;
    private String preferentialConditions;
    private String interestRateAfterMaturity;
    private String route;
    private String financialProductName;
    private String financialCompanyName;
    private String noticeSubmissionMonth;


    public ResponseProductInfo(ProductInfo pi) {
        this.bestInterestRate = pi.getBestInterestRate();
        this.savingRate = pi.getSavingRate();
        this.savingPeriod = pi.getSavingPeriod();
        this.accumulationTypeName = pi.getAccumulationTypeName();
        this.savingsRateTypeName = pi.getSavingsRateTypeName();
        this.maximumLimit = pi.getMaximumLimit();
        this.subscriptionTarget = pi.getSubscriptionTarget();
        this.subscriptionRestrictions = pi.getSubscriptionRestrictions();
        this.preferentialConditions = pi.getPreferentialConditions();
        this.interestRateAfterMaturity = pi.getInterestRateAfterMaturity();
        this.route = pi.getRoute();
        this.financialProductName = pi.getFinancialProductName();
        this.financialCompanyName = pi.getFinancialCompanyName();
        this.noticeSubmissionMonth = pi.getNoticeSubmissionMonth();
    }
}
