package com.p5.adoptions.services;

import com.p5.adoptions.repository.AnimalShelterRepository;
import com.p5.adoptions.repository.entity.Animal;
import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.model.AnimalShelterDTO;
import com.p5.adoptions.services.model.adapters.AnimalShelterAdapter;
import org.springframework.stereotype.Service;

@Service
public class AnimalShelterService {

    private final AnimalShelterRepository animalShelterRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository) {
        this.animalShelterRepository = animalShelterRepository;
    }

    public AnimalShelterDTO getShelter(Integer id) {
        return AnimalShelterAdapter.toDTO(animalShelterRepository.getOne(id));
    }

    public AnimalShelterDTO createShelter(AnimalShelterDTO animalShelterDTO) {
        AnimalShelter animalShelter = AnimalShelterAdapter.fromDTO(animalShelterDTO);
        animalShelter.setId(null);
        for (Animal animal : animalShelter.getAnimals()) {
            animal.setId(null);
        }
        return AnimalShelterAdapter.toDTO(animalShelterRepository.save(animalShelter));
    }

    public AnimalShelterDTO updateShelter(AnimalShelterDTO animalShelterDTO) {
        return AnimalShelterAdapter.toDTO(animalShelterRepository.save(AnimalShelterAdapter.fromDTO(animalShelterDTO)));
    }
}
