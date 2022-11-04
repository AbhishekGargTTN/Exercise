package com.GargAbhishek.JPAproject3.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private int streetNumber;
    private String location;
    private String State;
}
