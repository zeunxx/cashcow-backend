package com.bibimbob.cashcow.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="User_Assets")
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAssets {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_assets_id")
    private Long id;

    @Column(name="total_holdings")
    private Long totalHoldings;
    private Long salary;
    @Column(name="goal_amount")
    private Long goalAmount;

//    @Column(name="created_at")
//    private LocalDateTime createdAt;
//
//    @Column (name="modified_at")
//    private LocalDateTime modifiedAt;

    //== 생성 메소드==//
    @Builder
    public UserAssets(long totalHoldings, long salary, long goalAmount, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.totalHoldings = totalHoldings;
        this.salary = salary;
        this.goalAmount = goalAmount;
//        this.createdAt = createdAt;
//        this.modifiedAt = modifiedAt;
    }

    public void change(long totalHoldings, long salary, long goalAmount){
        this.totalHoldings = totalHoldings;
        this.salary = salary;
        this.goalAmount = goalAmount;
    }

}
