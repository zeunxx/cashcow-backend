package com.bibimbob.cashcow.dto.StockDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class PageInfo {
    private int pageNumber; // 현재 페이지
    private long totalElements; // 총 데이터 갯수
    private long totalPages; // 총 페이지 수
}
