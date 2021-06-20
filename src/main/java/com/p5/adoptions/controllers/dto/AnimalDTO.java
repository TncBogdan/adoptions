package com.p5.adoptions.controllers.dto;

import com.p5.adoptions.services.validations.OnCreate;
import com.p5.adoptions.services.validations.OnUpdate;

import javax.validation.constraints.*;

public record AnimalDTO(
        @Null(message = "Id must be null for creation.", groups = OnCreate.class)
        @NotNull(message = "Id must not be null.", groups = OnUpdate.class)
        @Positive
        Integer id,

        @NotNull
        @NotBlank
        @Size(min = 3, max = 50, message = "Name must have between 3 and 50 chars")
        String name,

        @NotNull
        @NotBlank
        String photo,

        @NotNull
        @NotBlank
        BreedEnum breed,

        @NotNull
        @NotBlank
        AnimalShelter shelter) {
}


