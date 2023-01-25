package com.bibimbob.cashcow.domain.UserAssets;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Saving")
public class Saving extends UserAssets{

    @Column(name="monthly_payment", nullable = false)
    private Long monthlyPayment;
}
