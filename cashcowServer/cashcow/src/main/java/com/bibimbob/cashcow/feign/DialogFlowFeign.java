package com.bibimbob.cashcow.feign;

import com.bibimbob.cashcow.dto.chatbot.RequestDto.RequestDepositDto;
import com.bibimbob.cashcow.dto.chatbot.RequestDto.RequestDto;


import com.bibimbob.cashcow.dto.chatbot.RequestDto.RequestLoanDto;
import com.bibimbob.cashcow.dto.chatbot.RequestDto.RequestSavingDto;
import com.bibimbob.cashcow.dto.chatbot.ResponseDto.DialogDepositDto;
import com.bibimbob.cashcow.dto.chatbot.ResponseDto.DialogFlowDto;
import com.bibimbob.cashcow.dto.chatbot.ResponseDto.DialogLoanDto;
import com.bibimbob.cashcow.dto.stockModel.RequestStockModelDto;
import com.bibimbob.cashcow.dto.stockModel.ResponseStockModelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="DialogFlowFeign", url="http://203.252.157.78:8080")
public interface DialogFlowFeign {

    /**
     * 챗봇 요청 메시지
     */
    @PostMapping(path = "/dialog-flow")
    public DialogFlowDto dialog_flow(
            @RequestBody RequestDto requestDto);


    /**
     * 챗봇 예금 정보 전송
     */
    @PostMapping(path="/deposit-products-search")
    public List<DialogDepositDto> deposit_products_search(
            @RequestBody RequestDepositDto requestDepositDto
            );

    /**
     * 챗봇 적금 정보 전송
     */
    @PostMapping(path="/saving-products-search")
    public List<DialogDepositDto> saving_products_search(
            @RequestBody RequestSavingDto requestSavingDto
            );

    /**
     * 챗봇 대출 정보 전송
     */
    @PostMapping(path = "/credit-loan-products-search")
    public List<DialogLoanDto> credit_loan_products_search(
            @RequestBody RequestLoanDto requestLoanDto
            );

    /**
     * 주식 모델 값 요청
     */
    @PostMapping(path = "/stock-prediction")
    public ResponseStockModelDto stock_model(
            @RequestBody RequestStockModelDto requestStockModelDto
            );
}
