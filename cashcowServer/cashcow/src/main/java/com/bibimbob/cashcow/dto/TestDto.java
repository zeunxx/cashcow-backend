package com.bibimbob.cashcow.dto;

import com.bibimbob.cashcow.domain.ChatResponse;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestDto {
    private String query;

    @Builder
    public TestDto(String query) {
        this.query = query;
    }
}
