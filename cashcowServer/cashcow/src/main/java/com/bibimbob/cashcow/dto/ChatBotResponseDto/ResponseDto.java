package com.bibimbob.cashcow.dto.ChatBotResponseDto;

import com.bibimbob.cashcow.domain.ChatResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class ResponseDto {
    private ChatResponse chatEnum;
    private String response;

    public ResponseDto(String response) {
        this.response = response;
        setChatEnum(response);
    }

    public void setChatEnum(String response) {
        if (response.equals("금융 용어")){
            this.chatEnum = ChatResponse.QUESTION_RESPONSE;
        } else if (response.equals( "적금")) {
            this.chatEnum = ChatResponse.REQUEST_SAVING;
        }else if (response.equals("정기 예금")) {
            this.chatEnum = ChatResponse.REQUEST_DEPOSIT;
        }else if (response.equals("대출")) {
            this.chatEnum = ChatResponse.REQUEST_LOAN;
        }else{
            this.chatEnum = ChatResponse.NORMAL;
        }
    }
}
