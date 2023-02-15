package com.bibimbob.cashcow.dto.chatbot.ResponseDto;

import com.bibimbob.cashcow.domain.ChatResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@NoArgsConstructor
public class DialogFlowDto {
    private String intent;
    private Optional<String> vocab;
    private String fulfillment_text;


    public DialogFlowDto(String intent, Optional<String> vocab, String fulfillment_text) {
        this.intent = intent;
        this.vocab = vocab;
        this.fulfillment_text = fulfillment_text;
    }

}
