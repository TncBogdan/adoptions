package com.p5.adoptions.services.adapters;

import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.domain.AnimalShelterDomain;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalShelterDomainMapper {

    AnimalShelter fromDomain(AnimalShelterDomain animalShelterDomain);

    AnimalShelterDomain toDomain(AnimalShelter animalShelter);

    List<AnimalShelterDomain> toListDomain(List<AnimalShelter> animalShelters);

}
