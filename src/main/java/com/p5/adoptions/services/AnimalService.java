package com.p5.adoptions.services;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.adapters.AnimalAdapter;
import com.p5.adoptions.repository.AnimalRepository;
import com.p5.adoptions.repository.AnimalShelterRepository;
import org.springframework.stereotype.Service;

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
        animalRepository.save(AnimalAdapter.fromDTO(animalDTO));
        return AnimalAdapter.toDTO(AnimalAdapter.fromDTO(animalDTO));
    }
}
