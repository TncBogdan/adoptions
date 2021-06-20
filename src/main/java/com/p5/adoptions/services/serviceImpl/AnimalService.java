package com.p5.adoptions.services.serviceImpl;

import com.p5.adoptions.services.domain.AnimalDomain;
import com.p5.adoptions.services.adapters.AnimalAdapter;
import com.p5.adoptions.services.validations.OnCreate;
import com.p5.adoptions.repository.AnimalRepository;
import com.p5.adoptions.repository.AnimalShelterRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalShelterRepository animalShelterRepository;

    public AnimalService(AnimalRepository animalRepository, AnimalShelterRepository animalShelterRepository) {
        this.animalRepository = animalRepository;
        this.animalShelterRepository = animalShelterRepository;
    }

    public AnimalDomain getOne(Integer id) {
        return AnimalAdapter.toDomain(animalRepository.getOne(id));
    }

    public List<AnimalDomain> getAll() {
        return AnimalAdapter.toListDomain(animalRepository.findAll());
    }

    @Validated(value = OnCreate.class)
    public AnimalDomain addAnimal(@Valid AnimalDomain animalDomain) {
        animalRepository.save(AnimalAdapter.fromDomain(animalDomain));
        return AnimalAdapter.toDomain(AnimalAdapter.fromDomain(animalDomain));
    }
}
