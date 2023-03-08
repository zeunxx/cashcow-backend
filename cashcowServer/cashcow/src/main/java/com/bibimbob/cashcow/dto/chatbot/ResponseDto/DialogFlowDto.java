package com.bibimbob.cashcow.dto.chatbot.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class DialogFlowDto {
    @JsonProperty("terms_description")
    private Map<String,String> termsDescription;
    @JsonProperty("fulfillment_text")
    private String fulfillmentText;
    @JsonProperty("intent")
    private String intent;


    public DialogFlowDto(Map<String,String> termsDescription, String fulfillmentText, String intent) {
        this.termsDescription = termsDescription;
        this.fulfillmentText = fulfillmentText;
        this.intent = intent;
    }


}
