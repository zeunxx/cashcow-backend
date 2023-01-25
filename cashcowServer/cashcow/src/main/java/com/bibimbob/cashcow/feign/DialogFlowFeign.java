package com.bibimbob.cashcow.feign;

import com.bibimbob.cashcow.dto.ChatBotDto.RequestDepositDto;
import com.bibimbob.cashcow.dto.ChatBotDto.RequestDto;
import com.bibimbob.cashcow.dto.TestDto;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
//    @PostMapping(path="/deposit-products-search")
//    public String deposit_products_search(
//            @RequestBody RequestDepositDto requestDepositDto
//            );

}
