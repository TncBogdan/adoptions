package com.p5.adoptions.controllers.mapper;

import com.p5.adoptions.controllers.dto.AnimalDTO;
import com.p5.adoptions.controllers.dto.AnimalShelterDTO;
import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.domain.AnimalDomain;
import com.p5.adoptions.services.domain.AnimalShelterDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalShelterMapper {

    AnimalShelterDomain toDomain(AnimalShelterDTO animalShelterDTO);

    AnimalShelterDTO toDTO(AnimalShelterDomain animalShelterDomain);

    List<AnimalShelterDTO> toListDTO(List<AnimalShelterDomain>animalShelterDomainList);
}
