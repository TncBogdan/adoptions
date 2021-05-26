package com.p5.adoptions.repository.entity;

import javax.persistence.Entity;


@Entity
public class Dog extends Animal{

    private String size;

    public Dog() {
    }

    public String getSize() {
        return size;
    }

    public Dog setSize(String size) {
        this.size = size;
        return this;
    }
}
