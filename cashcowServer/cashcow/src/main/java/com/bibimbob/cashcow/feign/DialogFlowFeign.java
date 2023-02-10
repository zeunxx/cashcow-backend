package com.bibimbob.cashcow.feign;

import com.bibimbob.cashcow.dto.ChatBotRequestDto.RequestDepositDto;
import com.bibimbob.cashcow.dto.ChatBotRequestDto.RequestDto;


import com.bibimbob.cashcow.dto.ChatBotRequestDto.RequestLoanDto;
import com.bibimbob.cashcow.dto.ChatBotRequestDto.RequestSavingDto;
import com.bibimbob.cashcow.dto.ChatBotResponseDto.ResponseDepositDto;
import com.bibimbob.cashcow.dto.ChatBotResponseDto.ResponseLoanDto;
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
    public String dialog_flow(
            @RequestBody RequestDto requestDto);


    /**
     * 챗봇 예금 정보 전송
     */
    @PostMapping(path="/deposit-products-search")
    public List<ResponseDepositDto> deposit_products_search(
            @RequestBody RequestDepositDto requestDepositDto
            );

    /**
     * 챗봇 적금 정보 전송
     */
    @PostMapping(path="/saving-products-search")
    public List<ResponseDepositDto> saving_products_search(
            @RequestBody RequestSavingDto requestSavingDto
            );

    /**
     * 챗봇 대출 정보 전송
     */
    @PostMapping(path = "/credit-loan-products-search")
    public List<ResponseLoanDto> credit_loan_products_search(
            @RequestBody RequestLoanDto requestLoanDto
            );

}
