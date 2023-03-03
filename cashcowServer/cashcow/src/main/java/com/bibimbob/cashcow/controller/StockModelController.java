package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.dto.stockModel.StockModelDto;
import com.bibimbob.cashcow.feign.DialogFlowFeign;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"주식 예측 모델 API"})
@RequiredArgsConstructor
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class StockModelController {

    private final DialogFlowFeign dialogFlowFeign;

    @PostMapping("/stockModel")
    public void stockModel(@RequestBody StockModelDto stockModelDto ){
        System.out.println("stockModelDto = " + stockModelDto);
    }
}
