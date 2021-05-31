package com.p5.adoptions.services.model;

import com.p5.adoptions.services.model.validations.OnCreate;
import com.p5.adoptions.services.model.validations.OnUpdate;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalShelterDTO {

    @Null(message = "Id must be null for creation.", groups = OnCreate.class)
    @NotNull(message = "Id must not be null.", groups = OnUpdate.class)
    @Positive
    private Integer id;

    @NotNull(message = "Name is mandatory.")
    @NotBlank
    @Size(min = 3, max = 100, message = "Must be between 3 and 100")
    private String name;

    @NotNull(message = "Address is mandatory.")
    @NotBlank
    @Size(min = 3, max = 100, message = "Must have between 3 and 100 chars")
    private String address;

    private List<AnimalDTO> animals = new ArrayList<>();

    public AnimalShelterDTO() {
    }

    public Integer getId() {
        return id;
    }

    public AnimalShelterDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelterDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AnimalShelterDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<AnimalDTO> getAnimals() {
        return animals;
    }

    public AnimalShelterDTO setAnimals(List<AnimalDTO> animals) {
        this.animals = animals;
        return this;
    }
}
