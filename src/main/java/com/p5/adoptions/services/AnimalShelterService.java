package com.p5.adoptions.services;

import com.p5.adoptions.repository.AnimalShelterRepository;
import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.model.AnimalShelterDTO;
import com.p5.adoptions.services.model.adapters.AnimalShelterAdapter;
import com.p5.adoptions.services.model.validations.OnCreate;
import com.p5.adoptions.services.model.validations.OnUpdate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class AnimalShelterService {

    private final AnimalShelterRepository animalShelterRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository) {
        this.animalShelterRepository = animalShelterRepository;
    }

    public List<AnimalShelterDTO> getAll() {
        return AnimalShelterAdapter.toListDTO(animalShelterRepository.findAll());
    }

    public AnimalShelterDTO getShelter(Integer id) {
        return AnimalShelterAdapter.toDTO(animalShelterRepository.getOne(id));
    }

    @Validated(OnCreate.class)
    public AnimalShelterDTO createShelter(@Valid AnimalShelterDTO animalShelterDTO) {

        AnimalShelter animalShelter = AnimalShelterAdapter.fromDTO(animalShelterDTO);

        return AnimalShelterAdapter.toDTO(animalShelterRepository.save(animalShelter));
    }

    @Validated(OnUpdate.class)
    public AnimalShelterDTO updateShelter(@Valid AnimalShelterDTO animalShelterDTO) {

        animalShelterRepository.findById(animalShelterDTO.getId())
                .orElseThrow(() -> new RuntimeException("Shelter not found."));

        return AnimalShelterAdapter.toDTO(animalShelterRepository.save(AnimalShelterAdapter.fromDTO(animalShelterDTO)));
    }
}
