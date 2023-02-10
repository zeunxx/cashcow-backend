package com.bibimbob.cashcow.domain;

public enum ChatResponse {
    NORMAL, // 일반 응답
    QUESTION_RESPONSE, // 용어질문에 대한 대답
    RECOMMEND_DEPOSIT, // 금융상품 추천 - 예금
    RECOMMEND_SAVING, // 금융상품 추천 - 적금
    RECOMMEND_LOAN, // 금융상품 추천 - 대출
    REQUEST // 정보 요청

}
