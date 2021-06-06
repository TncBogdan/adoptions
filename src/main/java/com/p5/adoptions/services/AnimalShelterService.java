package com.p5.adoptions.services;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.AnimalShelterDTO;
import com.p5.adoptions.model.adapters.AnimalShelterAdapter;
import com.p5.adoptions.model.validations.OnCreate;
import com.p5.adoptions.model.validations.OnUpdate;
import com.p5.adoptions.repository.AnimalShelterRepository;
import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.exceptions.AnimalShelterNotFoundException;
import com.p5.adoptions.services.exceptions.ShelterAddressException;
import com.p5.adoptions.services.exceptions.Violation;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Service
//@Validated
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
    public AnimalShelterDTO createShelter(AnimalShelterDTO animalShelterDTO) {

        validateShelter(animalShelterDTO);

        AnimalShelter animalShelter = AnimalShelterAdapter.fromDTO(animalShelterDTO);

        return AnimalShelterAdapter.toDTO(animalShelterRepository.save(animalShelter));
    }

    @Validated(OnUpdate.class)
    public AnimalShelterDTO updateShelter(AnimalShelterDTO animalShelterDTO) {

            validateShelter(animalShelterDTO);

//        try {
//            validateShelter(animalShelterDTO);
//        } catch (Exception e) {
//            Logger.getAnonymousLogger().warning(e.getMessage());
//            throw new RuntimeException(e);
//        }

        return AnimalShelterAdapter.toDTO(animalShelterRepository.save(AnimalShelterAdapter.fromDTO(animalShelterDTO)));
    }

    private void validateShelter(AnimalShelterDTO animalShelterDTO) {

        if (!animalShelterDTO.getAddress().toLowerCase(Locale.ROOT).contains("iasi") && (!animalShelterDTO.getAddress().toLowerCase(Locale.ROOT).contains("brasov"))) {
            throw new ShelterAddressException(new Violation("address", "Shelter is not from Iasi or Brasov", animalShelterDTO.getAddress()));
        }

        for (AnimalDTO animalDTO : animalShelterDTO.getAnimals()) {
            if (!animalDTO.getPhoto().toLowerCase(Locale.ROOT).contains("https")) {
                throw new RuntimeException("Animal does not have valid url");
            }
        }
        ////for animal
//        for (AnimalDTO animalDTO : animalShelterDTO.getAnimals()){
//            if (!animalDTO.getName().isEmpty()){
//                throw new RuntimeException("This shelter is empty");
//            }
//        }

        animalShelterRepository
                .findById(animalShelterDTO.getId())
                .orElseThrow(() -> new AnimalShelterNotFoundException("Shelter not found."));
    }
}
