package com.bibimbob.cashcow.dto.chatbot.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class DialogFlowDto {
    @JsonProperty("terms_description")
    private TermsDescription termsDescription;
    @JsonProperty("fulfillment_text")
    private String fulfillmentText;
    @JsonProperty("intent")
    private String intent;


    public DialogFlowDto(TermsDescription termsDescription, String fulfillmentText, String intent) {
        this.termsDescription = termsDescription;
        this.fulfillmentText = fulfillmentText;
        this.intent = intent;
    }


}
