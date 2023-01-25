package com.bibimbob.cashcow.domain;

public enum ChatResponse {
    USER_INFO("user_info"), // 유저 정보
    REQUEST("request"), // 고객 요청 메시지
    RESPONSE("response"), // 일반 응답 메시지
    STOCK_INFO("stock_info"), // 주식 정보
    STOCK_DEF("stock_definition"), // 주식 용어 뜻
    FINANCE_INFO("finance_info"), // 금융 정보
    FINANCE_DEF("finance_def"); // 금융 용어 뜻

    private String type;
    ChatResponse(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }


}
