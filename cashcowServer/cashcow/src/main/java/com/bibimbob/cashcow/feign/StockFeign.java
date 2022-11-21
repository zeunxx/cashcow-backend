package com.bibimbob.cashcow.feign;

import com.bibimbob.cashcow.dto.stock.StockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="stockFeign", url="http://apis.data.go.kr/1160100/service")
public interface StockFeign {
    @GetMapping(path="/GetStockSecuritiesInfoService/getStockPriceInfo")
    public StockDto getStockPriceInfo(
            @RequestParam("serviceKey") String service_key,
            @RequestParam("resultType") String resultType
    );
}
