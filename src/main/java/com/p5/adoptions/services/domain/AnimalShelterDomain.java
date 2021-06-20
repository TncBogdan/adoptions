package com.p5.adoptions.services.domain;

import com.p5.adoptions.services.validations.OnCreate;
import com.p5.adoptions.services.validations.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
