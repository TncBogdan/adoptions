package com.p5.adoptions.services.adapters;

import com.p5.adoptions.services.domain.AnimalDomain;
import com.p5.adoptions.repository.entity.Animal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalDomainMapper {
    Animal fromDomain(AnimalDomain animalDomain);

    List<Animal> fromListDomain(List<AnimalDomain> animalDomains);

    AnimalDomain toDomain(Animal animal);

    List<AnimalDomain> toListDomain(List<Animal> animalList);
}
