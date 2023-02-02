package com.bibimbob.cashcow.domain.Stock;

import com.bibimbob.cashcow.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;


@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class FavoriteStock {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "stock_code")
    private Long stockCode;

    //== 생성자 ==//
    public FavoriteStock(User user, Long stockCode) {
        this.user = user;
        this.stockCode = stockCode;
    }

    //==비즈니스 로직==//


    @Override
    public String toString() {
        return "FavoriteStock{" +
                ", user=" + user.getName() +
                ", stockCode=" + stockCode +
                '}';
    }
}