package com.bibimbob.cashcow.dto.stockModel;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ApiModel(value = "주식 예측 모델", description = "주식예측 모델 dto")
public class StockModelDto {

    private List<String> stockPrice;
	private long predictDays;
}
