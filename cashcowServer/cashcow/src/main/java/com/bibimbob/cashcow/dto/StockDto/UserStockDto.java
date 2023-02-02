package com.bibimbob.cashcow.dto.StockDto;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ApiModel(value = "유저 주식 즐겨찾기", description = "유저 주식 즐겨찾기 모음를 가진 Domain Class")
public class UserStockDto {

    @ApiModelProperty(value = "유저 코드")
    private long id;

    @ApiModelProperty(value = "주식 코드")
    private long stockCode;

}
