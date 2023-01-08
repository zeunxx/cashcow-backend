package com.bibimbob.cashcow.dto.ChatBotDto;

import com.bibimbob.cashcow.domain.ChatResponse;
import com.bibimbob.cashcow.dto.TestDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {
    private ChatResponse chatResponse;
    private String response;

    @Builder
    public ResponseDto(ChatResponse chatResponse, String response) {
        this.chatResponse = chatResponse;
        this.response = response;
    }
}
