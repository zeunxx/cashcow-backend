package com.bibimbob.cashcow.dto.ChatBotResponseDto;

import com.bibimbob.cashcow.domain.ChatResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private ChatResponse chatEnum;
    private String response;
}
