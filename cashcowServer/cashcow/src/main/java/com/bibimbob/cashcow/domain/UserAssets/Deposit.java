package com.bibimbob.cashcow.domain.UserAssets;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Deposit")
public class Deposit extends UserAssets {
}
