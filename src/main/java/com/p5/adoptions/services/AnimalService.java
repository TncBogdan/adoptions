package com.p5.adoptions.services;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.adapters.AnimalAdapter;
import com.p5.adoptions.repository.AnimalRepository;
import com.p5.adoptions.repository.AnimalShelterRepository;
import com.p5.adoptions.repository.entity.Animal;
import com.p5.adoptions.repository.entity.AnimalShelter;
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

    public AnimalDTO addAnimal(AnimalDTO animalDTO) {

        AnimalShelter animalShelter = new AnimalShelter();

//        if (!shelterName.equals(animalShelterRepository.findByName(animalShelter.getName()))) {
//            throw new RuntimeException("Incorect shelter name.");
//        }

        List<AnimalDTO> animalDTOS = new ArrayList<>();

//        animalDTOS.add(AnimalAdapter.fromDTO(animalDTO.setName(animalDTO.getName()).setPhoto(animalDTO.getPhoto())));

        animalShelter.setAnimals(AnimalAdapter.fromListDTO(animalDTOS));

        return animalDTO;
    }
}
