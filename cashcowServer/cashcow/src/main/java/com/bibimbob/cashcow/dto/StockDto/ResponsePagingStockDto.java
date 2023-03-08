package com.bibimbob.cashcow.dto.StockDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponsePagingStockDto {

    private List<ResponseStockDto> responseStockDtos;
    private PageInfo pageInfo;
}
