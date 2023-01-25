package com.bibimbob.cashcow.domain.UserAssets;

import com.bibimbob.cashcow.exception.NotEnoughAmountException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="User_Assets")
public abstract class UserAssets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_assets_id")
    private Long id;

    @Column(name="expected_period", nullable = false)
    private Long expectedPeriod;

    @Column(name="saving_amount", nullable = false)
    private Long savingAmount;


    /**
     *  생성자
     */
    public UserAssets(Long id, Long expectedPeriod, Long savingAmount) {
        this.id = id;
        this.expectedPeriod = expectedPeriod;
        this.savingAmount = savingAmount;
    }

    //== 비즈니스 로직 ==//

    /**
     *  필드 변경 함수
     */
    public void change(Long expectedPeriod, Long savingAmount) {
        if(expectedPeriod<1){
            throw new NotEnoughAmountException("need more period");
        }else{
            this.expectedPeriod = expectedPeriod;
        }

        if(savingAmount<1){
            throw new NotEnoughAmountException("need more amount");
        }else{
            this.savingAmount = savingAmount;
        }
    }
}
