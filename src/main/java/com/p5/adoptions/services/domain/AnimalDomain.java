package com.p5.adoptions.services.domain;

import com.p5.adoptions.services.validations.OnCreate;
import com.p5.adoptions.services.validations.OnUpdate;
import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.repository.entity.BreedEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class AnimalDomain {

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

}
