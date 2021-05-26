package com.p5.adoptions.services.model.adapters;

import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.model.AnimalShelterDTO;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelterAdapter {

    public static AnimalShelter toAnimalShelter(AnimalShelterDTO animalShelterDTO) {
        return new AnimalShelter()
                .setName(animalShelterDTO.getName())
                .setAddress(animalShelterDTO.getAddress())
                .setId(animalShelterDTO.getId())
                .setAnimals(AnimalAdapter.toAnimalList(animalShelterDTO.getAnimals()));
    }

    public static AnimalShelterDTO toAnimalShelterDTO(AnimalShelter animalShelter) {
        return new AnimalShelterDTO()
                .setId(animalShelter.getId())
                .setName(animalShelter.getName())
                .setAddress(animalShelter.getAddress())
                .setAnimals(AnimalAdapter.toListDTO(animalShelter.getAnimals()));
    }

    public static List<AnimalShelterDTO> toAnimalShelterDTOList(List<AnimalShelter> animalShelters) {
        List<AnimalShelterDTO> list = new ArrayList<>();
        animalShelters.forEach(animalShelter -> list.add(toAnimalShelterDTO(animalShelter)));
        return list;
    }

}
