package com.p5.adoptions.model;

import org.springframework.stereotype.Repository;

@Repository
public class Animal {

    private String name;
    private String photoUrl;

    public Animal() {
    }

    public Animal(String name, String photoUrl) {
        this.name = name;
        this.photoUrl = photoUrl;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Animal setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

}
