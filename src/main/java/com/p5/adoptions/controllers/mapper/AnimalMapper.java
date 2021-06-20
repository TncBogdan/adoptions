package com.p5.adoptions.controllers.mapper;

import com.p5.adoptions.controllers.dto.AnimalDTO;
import com.p5.adoptions.services.domain.AnimalDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
    AnimalDomain toDomain(AnimalDTO animalDTO);
}
