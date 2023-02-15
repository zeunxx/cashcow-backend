package com.bibimbob.cashcow.domain;

public enum ChatResponse {
    NORMAL, // 일반 응답(Default Fallback Intent)
    QUESTION_RESPONSE, // 용어질문에 대한 대답 (금융용어)
    REQUEST_DEPOSIT, // 금융상품 추천 - 예금 (정기 예름)
    REQUEST_SAVING, // 금융상품 추천 - 적금 (적금)
    REQUEST_LOAN, // 금융상품 추천 - 대출 (대출)



}
