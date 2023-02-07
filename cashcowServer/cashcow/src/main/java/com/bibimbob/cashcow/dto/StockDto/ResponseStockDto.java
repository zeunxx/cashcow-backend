package com.bibimbob.cashcow.dto.StockDto;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class ResponseStockDto {
    List<UserStockDto> stockDtoList = new ArrayList<>();

    public ResponseStockDto(List<FavoriteStock> stockList) {
        for (FavoriteStock stock : stockList) {
            UserStockDto userStockDto = new UserStockDto(stock.getUser().getId(), stock.getStockCode());
            stockDtoList.add(userStockDto);
        }
    }
}
