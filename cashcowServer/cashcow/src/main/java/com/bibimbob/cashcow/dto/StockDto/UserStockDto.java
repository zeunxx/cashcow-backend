package com.bibimbob.cashcow.dto.StockDto;

import com.bibimbob.cashcow.domain.Stock.FavoriteStock;
import com.bibimbob.cashcow.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("user_pk")
    private long userPk;

    @ApiModelProperty(value = "주식 코드")
    @JsonProperty("stock_code")
    private long stockCode;

}
