package com.p5.adoptions.services.serviceImpl;

import com.p5.adoptions.services.domain.AnimalDomain;
import com.p5.adoptions.services.domain.AnimalShelterDomain;
import com.p5.adoptions.services.adapters.AnimalShelterAdapter;
import com.p5.adoptions.services.validations.OnCreate;
import com.p5.adoptions.services.validations.OnUpdate;
import com.p5.adoptions.repository.AnimalRepository;
import com.p5.adoptions.repository.AnimalShelterRepository;
import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.exceptions.ShelterAddressException;
import com.p5.adoptions.services.exceptions.Violation;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Service
@Validated
public class AnimalShelterService {

    private final AnimalShelterRepository animalShelterRepository;
    private final AnimalRepository animalRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository, AnimalRepository animalRepository) {
        this.animalShelterRepository = animalShelterRepository;
        this.animalRepository = animalRepository;
    }

    public AnimalShelterDomain getShelter(Integer id) {
        return AnimalShelterAdapter.toDomain(animalShelterRepository.getOne(id));
    }

    public List<AnimalShelterDomain> getAll() {
        return AnimalShelterAdapter.toListDomain(animalShelterRepository.findAll());
    }

    @Validated(OnCreate.class)
    public AnimalShelterDomain createShelter(@Valid AnimalShelterDomain animalShelterDomain) {

        validateShelter(animalShelterDomain);

//        animalShelterRepository
//                .findById(animalShelterDTO.getId())
//                .orElseThrow(() -> new AnimalShelterNotFoundException("Shelter not found."));

        AnimalShelter animalShelter = AnimalShelterAdapter.fromDomain(animalShelterDomain);

        return AnimalShelterAdapter.toDomain(animalShelterRepository.save(animalShelter));
    }

    @Validated(OnUpdate.class)
    public AnimalShelterDomain updateShelter(@Valid AnimalShelterDomain animalShelterDomain) {

        validateShelter(animalShelterDomain);

//        try {
//            validateShelter(animalShelterDTO);
//        } catch (Exception e) {
//            Logger.getAnonymousLogger().warning(e.getMessage());
//            throw new RuntimeException(e);
//        }

        return AnimalShelterAdapter.toDomain(animalShelterRepository.save(AnimalShelterAdapter.fromDomain(animalShelterDomain)));
    }


    private void validateShelter(AnimalShelterDomain animalShelterDomain) {

        if (!animalShelterDomain.getAddress().toLowerCase(Locale.ROOT).contains("iasi") && (!animalShelterDomain.getAddress().toLowerCase(Locale.ROOT).contains("brasov"))) {
            throw new ShelterAddressException(new Violation("address", "Shelter is not from Iasi or Brasov", animalShelterDomain.getAddress()));
        }

        for (AnimalDomain animalDomain : animalShelterDomain.getAnimals()) {
            if (!animalDomain.getPhoto().toLowerCase(Locale.ROOT).contains("https")) {
                throw new RuntimeException("Animal does not have valid url");
            }
        }
    }
}
