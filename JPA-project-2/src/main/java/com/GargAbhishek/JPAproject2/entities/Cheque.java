package com.GargAbhishek.JPAproject2.entities;

import javax.persistence.*;

@Entity
@Table(name = "cheque")
//@DiscriminatorValue("ch")
//@PrimaryKeyJoinColumn(name = "id")
public class Cheque extends Payment{
    @Column(name = "chequenumber")
    private String chequeNumber;

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }
}
