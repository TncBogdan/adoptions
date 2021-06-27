package com.p5.adoptions.services;

import com.p5.adoptions.services.model.AnimalShelterDomain;
import com.p5.adoptions.services.validations.OnCreate;
import com.p5.adoptions.services.validations.OnUpdate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
public interface IAnimalShelterService {

    AnimalShelterDomain get(Integer id);

    List<AnimalShelterDomain> getAll();

    @Validated(OnCreate.class)
    AnimalShelterDomain add(@Valid AnimalShelterDomain animalShelterDomain);

    @Validated(OnUpdate.class)
    AnimalShelterDomain updateShelter(@Valid AnimalShelterDomain animalShelterDomain);
}
