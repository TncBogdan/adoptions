package com.p5.adoptions.model;

import org.springframework.stereotype.Repository;

@Repository
public class Animal {

    private String name;
    private String photo;

    public Animal() {
    }

    public Animal(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public void speak(){
        //todo inheritance
    }

    protected void walk(){

    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Animal setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

}
