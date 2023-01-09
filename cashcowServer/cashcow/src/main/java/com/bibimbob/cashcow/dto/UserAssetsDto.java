package com.bibimbob.cashcow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
public class UserAssetsDto {
    private Long totalHoldings;
    private Long salary;
    private Long goalAmount;
//    private LocalDateTime modifiedAt;


    public UserAssetsDto(long totalHoldings, long salary, long goalAmount) {
        this.totalHoldings = totalHoldings;
        this.salary = salary;
        this.goalAmount = goalAmount;
    }
}
