package com.p5.adoptions.services.serviceImpl;

import com.p5.adoptions.services.domain.AnimalDomain;
import com.p5.adoptions.services.domain.AnimalShelterDomain;
import com.p5.adoptions.services.adapters.AnimalShelterDomainMapper;
import com.p5.adoptions.services.validations.OnCreate;
import com.p5.adoptions.services.validations.OnUpdate;
import com.p5.adoptions.repository.AnimalRepository;
import com.p5.adoptions.repository.AnimalShelterRepository;
import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.exceptions.ShelterAddressException;
import com.p5.adoptions.services.exceptions.Violation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Service
@Validated
@RequiredArgsConstructor
public class AnimalShelterService {

    private final AnimalShelterRepository animalShelterRepository;
    private final AnimalRepository animalRepository;
    AnimalShelterDomainMapper animalShelterDomainMapper;

    public AnimalShelterDomain getShelter(Integer id) {
        return animalShelterDomainMapper.toDomain(animalShelterRepository.getOne(id));
    }

    public List<AnimalShelterDomain> getAll() {
        return animalShelterDomainMapper.toListDomain(animalShelterRepository.findAll());
    }

    @Validated(OnCreate.class)
    public AnimalShelterDomain createShelter(@Valid AnimalShelterDomain animalShelterDomain) {

        validateShelter(animalShelterDomain);

//        animalShelterRepository
//                .findById(animalShelterDTO.getId())
//                .orElseThrow(() -> new AnimalShelterNotFoundException("Shelter not found."));

        var animalShelter = animalShelterDomainMapper.fromDomain(animalShelterDomain);

        return animalShelterDomainMapper.toDomain(animalShelterRepository.save(animalShelter));
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

        return animalShelterDomainMapper.toDomain(animalShelterRepository.save(animalShelterDomainMapper.fromDomain(animalShelterDomain)));
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
