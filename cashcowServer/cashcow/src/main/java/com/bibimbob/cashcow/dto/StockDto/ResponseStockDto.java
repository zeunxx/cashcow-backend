package com.bibimbob.cashcow.dto.StockDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class ResponseStockDto {
    List<UserStockDto> stockDtoList = new ArrayList<>();
}
