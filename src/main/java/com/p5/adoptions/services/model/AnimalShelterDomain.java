package com.p5.adoptions.services.model;

import com.p5.adoptions.services.validations.OnCreate;
import com.p5.adoptions.services.validations.OnUpdate;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalShelterDomain {

    @Null(message = "Id must be null for creation.", groups = OnCreate.class)
    @NotNull(message = "Id must not be null.", groups = OnUpdate.class)
    @Positive
    private Integer id;

    @NotNull(message = "Name is mandatory.")
    @NotBlank
    @Size(min = 3, max = 100, message = "Must have between 3 and 100")
    private String name;

    @NotNull(message = "Address is mandatory.")
    @NotBlank
    @Size(min = 3, max = 100, message = "Must have between 3 and 100 chars")
    private String address;

    private List<AnimalDomain> animals = new ArrayList<>();

    public AnimalShelterDomain() {
    }

    public Integer getId() {
        return id;
    }

    public AnimalShelterDomain setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelterDomain setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AnimalShelterDomain setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<AnimalDomain> getAnimals() {
        return animals;
    }

    public AnimalShelterDomain setAnimals(List<AnimalDomain> animals) {
        this.animals = animals;
        return this;
    }
}
