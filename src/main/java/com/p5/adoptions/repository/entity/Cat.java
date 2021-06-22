package com.p5.adoptions.repository.entity;

import javax.persistence.Entity;


@Entity
public class Cat extends Animal{

    private String purrLevel;

    public Cat() {
    }

    public String getPurrLevel() {
        return purrLevel;
    }

    public Cat setPurrLevel(String purrLevel) {
        this.purrLevel = purrLevel;
        return this;
    }
}
