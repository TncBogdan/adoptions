package com.p5.adoptions.services.serviceImpl;

import com.p5.adoptions.services.IAnimalService;
import com.p5.adoptions.services.model.AnimalDomain;
import com.p5.adoptions.services.adapters.AnimalAdapter;
import com.p5.adoptions.repository.repositoryInterfaces.AnimalRepository;
import com.p5.adoptions.repository.repositoryInterfaces.AnimalShelterRepository;
import com.p5.adoptions.repository.entity.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

public class AnimalService implements IAnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalShelterRepository animalShelterRepository;

    public AnimalService(AnimalRepository animalRepository, AnimalShelterRepository animalShelterRepository) {
        this.animalRepository = animalRepository;
        this.animalShelterRepository = animalShelterRepository;
    }

    public AnimalDomain get(Integer id) {
        return AnimalAdapter.toDomain(animalRepository.getOne(id));
    }

    public List<AnimalDomain> getAll() {
        return AnimalAdapter.toListDomain(animalRepository.findAll());
    }

    public AnimalDomain add(AnimalDomain animalDomain) {
        Animal animal = AnimalAdapter.fromDomain(animalDomain);
        return AnimalAdapter.toDomain(animal);
    }
}
