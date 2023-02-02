package com.bibimbob.cashcow.dto.ChatBotResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDepositDto {
    @JsonProperty("product_info")
    private ProductInfo productInfo;
    @JsonProperty("estimated_saving")
    private int estimatedSaving;

}
