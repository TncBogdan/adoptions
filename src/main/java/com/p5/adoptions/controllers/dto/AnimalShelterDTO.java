package com.p5.adoptions.controllers.dto;

import com.p5.adoptions.services.validations.OnCreate;
import com.p5.adoptions.services.validations.OnUpdate;

import javax.validation.constraints.*;

public record AnimalShelterDTO(

        @Null(message = "Id must be null for creation.", groups = OnCreate.class)
        @NotNull(message = "Id must not be null.", groups = OnUpdate.class)
        @Positive
        Integer id,

        @NotNull(message = "Name is mandatory.")
        @NotBlank
        @Size(min = 3, max = 100, message = "Must have between 3 and 100")
        String name,

        @NotNull(message = "Address is mandatory.")
        @NotBlank
        @Size(min = 3, max = 100, message = "Must have between 3 and 100 chars")
        String address) {
}

