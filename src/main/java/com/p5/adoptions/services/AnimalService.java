package com.p5.adoptions.services;

import com.p5.adoptions.repository.AnimalRepository;
import com.p5.adoptions.repository.AnimalShelterRepository;
import com.p5.adoptions.repository.entity.Animal;
import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.model.AnimalDTO;
import com.p5.adoptions.services.model.adapters.AnimalAdapter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalShelterRepository animalShelterRepository;

    public AnimalService(AnimalRepository animalRepository, AnimalShelterRepository animalShelterRepository) {
        this.animalRepository = animalRepository;
        this.animalShelterRepository = animalShelterRepository;
    }

    public AnimalDTO getOne(Integer id) {
        return AnimalAdapter.toDTO(animalRepository.getOne(id));
    }

    public List<AnimalDTO> getAll() {
        return AnimalAdapter.toListDTO(animalRepository.findAll());
    }

    public AnimalShelter addAnimal(AnimalDTO animalDTO, String shelterName) {

        AnimalShelter animalShelter = new AnimalShelter();

        if (!shelterName.equals(animalShelterRepository.findByName(animalShelter.getName()))) {
            throw new RuntimeException("Incorect shelter name.");
        }

        List<Animal> animalDTOS = new ArrayList<>();

        animalDTOS.add(AnimalAdapter.fromDTO(animalDTO.setName(animalDTO.getName()).setPhoto(animalDTO.getPhoto())));

        animalShelter.setAnimals(animalDTOS);

        return animalShelter;
    }
}
