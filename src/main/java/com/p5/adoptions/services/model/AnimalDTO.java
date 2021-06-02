package com.p5.adoptions.services.model;

import com.p5.adoptions.services.model.validations.OnCreate;
import com.p5.adoptions.services.model.validations.OnUpdate;
import org.springframework.stereotype.Repository;

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

    public AnimalDTO() {
    }

    public AnimalDTO(Integer id, String name, String photo) {
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
