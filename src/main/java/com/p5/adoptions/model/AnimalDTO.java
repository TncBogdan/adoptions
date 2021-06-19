package com.p5.adoptions.model;

import com.p5.adoptions.model.validations.OnCreate;
import com.p5.adoptions.model.validations.OnUpdate;
import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.repository.entity.BreedEnum;

import javax.validation.constraints.*;

public class AnimalDTO {

    @Null(message = "Id must be null for creation.", groups = OnCreate.class)
    @NotNull(message = "Id must not be null.", groups = OnUpdate.class)
    @Positive
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50, message = "Name must have between 3 and 50 chars")
    private String name;

    @NotNull
    @NotBlank
    private String photo;

    @NotNull
    @NotBlank
    protected BreedEnum breed;

    @NotNull
    @NotBlank
    private AnimalShelter shelter;

    public AnimalDTO() {
    }

    public AnimalDTO(Integer id, String name, String photo, BreedEnum breed, AnimalShelter shelter) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.breed = breed;
        this.shelter = shelter;
    }

    public void speak() {
        //todo inheritance
    }

    protected void walk() {

    }

    public BreedEnum getBreed() {
        return breed;
    }

    public AnimalDTO setBreed(BreedEnum breed) {
        this.breed = breed;
        return this;
    }

    public AnimalShelter getShelter() {
        return shelter;
    }

    public AnimalDTO setShelter(AnimalShelter shelter) {
        this.shelter = shelter;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public AnimalDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public AnimalDTO setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

}
