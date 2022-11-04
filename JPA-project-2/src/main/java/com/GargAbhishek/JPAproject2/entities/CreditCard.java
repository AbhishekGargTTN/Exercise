package com.GargAbhishek.JPAproject2.entities;

import javax.persistence.*;

@Entity
@Table(name = "creditcard")
//@DiscriminatorValue("cc")
//@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment{
    @Column(name = "cardnumber")
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
