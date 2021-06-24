package com.p5.adoptions.controllers.adapters;

import com.p5.adoptions.controllers.dto.AnimalShelterDTO;
import com.p5.adoptions.services.model.AnimalShelterDomain;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelterAdapterDTO {

    public static AnimalShelterDomain fromDTO(AnimalShelterDTO animalShelterDTO) {
        return new AnimalShelterDomain()
                .setName(animalShelterDTO.getName())
                .setAddress(animalShelterDTO.getAddress())
                .setId(animalShelterDTO.getId())
                .setAnimals(AnimalAdapterDTO.fromListDTO(animalShelterDTO.getAnimals()));
    }

    public static AnimalShelterDTO toDTO(AnimalShelterDomain animalShelterDomain) {
        return new AnimalShelterDTO()
                .setId(animalShelterDomain.getId())
                .setName(animalShelterDomain.getName())
                .setAddress(animalShelterDomain.getAddress())
                .setAnimals(AnimalAdapterDTO.toListDTO(animalShelterDomain.getAnimals()));
    }

    public static List<AnimalShelterDTO> toListDTO(List<AnimalShelterDomain> animalSheltersDomain) {
        List<AnimalShelterDTO> list = new ArrayList<>();
        animalSheltersDomain.forEach(animalShelter -> list.add(toDTO(animalShelter)));
        return list;
    }

}
