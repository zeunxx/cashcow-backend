package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.dto.stock.StockDto;
import com.bibimbob.cashcow.feign.StockFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"주식 API"})
@RequiredArgsConstructor
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class StockController {

    @Value("${service_key}")
    private String service_key;
    private final StockFeign stockFeign;

    @ApiOperation(value = "주식 시세 조회", notes = "주식 시세를 조회하는 API입니다.")
    @GetMapping("/getStockPriceInfo") // 주식시세
    public StockDto getStockPriceInfo(){
        StockDto stockDto = stockFeign.getStockPriceInfo(service_key,"json");

        return stockDto;
    }


}
