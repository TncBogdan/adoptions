package com.p5.adoptions.services.serviceImpl;

import com.p5.adoptions.repository.AnimalRepository;
import com.p5.adoptions.repository.AnimalShelterRepository;
import com.p5.adoptions.services.adapters.AnimalDomainMapper;
import com.p5.adoptions.services.domain.AnimalDomain;
import com.p5.adoptions.services.validations.OnCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalShelterRepository animalShelterRepository;
    AnimalDomainMapper animalDomainMapper;

    public AnimalDomain getOne(Integer id) {
        return animalDomainMapper.toDomain(animalRepository.getOne(id));
    }

    public List<AnimalDomain> getAll() {
        return animalDomainMapper.toListDomain(animalRepository.findAll());
    }

    @Validated(value = OnCreate.class)
    public AnimalDomain addAnimal(@Valid AnimalDomain animalDomain) {
        animalRepository.save(animalDomainMapper.fromDomain(animalDomain));
        return animalDomainMapper.toDomain(animalDomainMapper.fromDomain(animalDomain));
    }
}
