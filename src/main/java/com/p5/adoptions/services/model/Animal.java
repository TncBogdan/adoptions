package com.p5.adoptions.services.model;

import org.springframework.stereotype.Repository;

@Repository
public class Animal {

    private Integer id;
    private String name;
    private String photo;

    public Animal() {
    }

    public Animal(Integer id, String name, String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public void speak(){
        //todo inheritance
    }

    protected void walk(){

    }

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
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
