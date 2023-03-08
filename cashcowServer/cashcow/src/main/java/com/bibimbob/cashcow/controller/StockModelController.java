package com.bibimbob.cashcow.controller;

import com.bibimbob.cashcow.dto.stockModel.RequestStockModelDto;
import com.bibimbob.cashcow.dto.stockModel.ResponseStockModelDto;
import com.bibimbob.cashcow.dto.stockModel.StockModelDto;
import com.bibimbob.cashcow.feign.DialogFlowFeign;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.Collectors.toList;

@RestController
@Api(tags = {"주식 예측 모델 API"})
@RequiredArgsConstructor
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class StockModelController {

    private final DialogFlowFeign dialogFlowFeign;

    @PostMapping("/stockModel")
    public ResponseStockModelDto stockModel(@RequestBody StockModelDto stockModelDto){

        return dialogFlowFeign.stock_model(new RequestStockModelDto(stockModelDto.getStockPrice()
                .stream()
                .map(s -> Integer.parseInt(s))
                .collect(toList()), stockModelDto.getPredictDays()));
    }
}
