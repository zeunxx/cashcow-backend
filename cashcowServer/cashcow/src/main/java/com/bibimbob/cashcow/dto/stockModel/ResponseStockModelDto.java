package com.bibimbob.cashcow.dto.stockModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStockModelDto {
    private List<Integer> predictedPrice;
}
