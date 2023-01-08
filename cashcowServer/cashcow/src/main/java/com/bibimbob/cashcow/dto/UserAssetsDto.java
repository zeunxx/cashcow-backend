package com.bibimbob.cashcow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAssetsDto {
    private Long totalHoldings;
    private Long salary;
    private Long goalAmount;
//    private LocalDateTime modifiedAt;
}
