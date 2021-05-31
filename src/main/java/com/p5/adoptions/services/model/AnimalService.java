package com.p5.adoptions.services.model;

import com.p5.adoptions.repository.AnimalRepository;
import com.p5.adoptions.services.model.adapters.AnimalAdapter;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public AnimalDTO getOne(Integer id){
        return AnimalAdapter.toDTO(animalRepository.getOne(id));
    }
}
