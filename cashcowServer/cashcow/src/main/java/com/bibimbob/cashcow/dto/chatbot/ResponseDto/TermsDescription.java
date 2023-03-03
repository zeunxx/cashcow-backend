package com.bibimbob.cashcow.dto.chatbot.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TermsDescription {
    // TODO: 2023-03-03 딕셔너리 처리 필요
    private List<Map> maps;
}
