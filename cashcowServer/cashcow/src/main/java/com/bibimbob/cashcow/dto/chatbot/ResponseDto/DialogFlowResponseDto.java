package com.bibimbob.cashcow.dto.chatbot.ResponseDto;

import com.bibimbob.cashcow.domain.ChatResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DialogFlowResponseDto {

    private Optional<String> vocab;
    private String fulfillment_text;
    private ChatResponse chatEnum;

    public DialogFlowResponseDto(Optional<String> vocab, String fulfillment_text, String intent) {
        this.vocab = vocab;
        this.fulfillment_text = fulfillment_text;

        // set ChatEnum
        if(intent.equals("금융 용어")){
            chatEnum = ChatResponse.QUESTION_RESPONSE;
        } else if (intent.equals("정기 예금")) {
            chatEnum = ChatResponse.REQUEST_DEPOSIT;
        } else if (intent.equals("적금")) {
            chatEnum = ChatResponse.REQUEST_SAVING;
        } else if (intent.equals("대출")) {
            chatEnum = ChatResponse.REQUEST_LOAN;
        } else if (intent.equals("Default Fallback Intent")) {
            chatEnum = ChatResponse.NORMAL;
        } else {
            chatEnum = ChatResponse.NORMAL;
        }
    }

}
