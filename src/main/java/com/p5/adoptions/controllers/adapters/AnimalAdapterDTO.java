package com.p5.adoptions.controllers.adapters;

import com.p5.adoptions.controllers.dto.AnimalDTO;
import com.p5.adoptions.repository.entity.Animal;
import com.p5.adoptions.services.model.AnimalDomain;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapterDTO {
    public static AnimalDomain fromDTO(AnimalDTO animalDTO){
        return new AnimalDomain().setName(animalDTO.name())
                .setPhoto(animalDTO.photo());
    }

    public static List<AnimalDomain> fromListDTO(List<AnimalDTO> animalDTOList){
        List<AnimalDomain>animals = new ArrayList<>();
        for (AnimalDTO animal : animalDTOList){
            animals.add(fromDTO(animal));
        }
        return animals;
    }

    public static AnimalDTO toDTO(AnimalDomain animalDomain) {
        return new AnimalDTO(animalDomain.getId(), animalDomain.getName(), animalDomain.getPhoto());
    }

    public static List<AnimalDTO> toListDTO(List<AnimalDomain> animalList) {
        List<AnimalDTO> dtoList = new ArrayList<>();
        animalList.forEach(animal -> dtoList.add(toDTO(animal)));
        return dtoList;
    }
}
