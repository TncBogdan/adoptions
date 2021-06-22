package com.p5.adoptions.controllers.adapters;

import com.p5.adoptions.controllers.dto.AnimalDTO;
import com.p5.adoptions.repository.entity.Animal;
import com.p5.adoptions.services.model.AnimalDomain;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter {
    public static Animal fromDTO(AnimalDTO animalDTO){
        return new Animal().setName(animalDTO.name())
                .setPhoto(animalDTO.photo());
    }

    public static List<Animal> fromListDTO(List<AnimalDTO> animalDTOList){
        List<Animal>animals = new ArrayList<>();
        for (AnimalDTO animal : animalDTOList){
            animals.add(fromDTO(animal));
        }
        return animals;
    }

    public static AnimalDTO toDTO(Animal animal) {
        return new AnimalDTO(animal.getId(), animal.getName(), animal.getPhoto());
    }

    public static List<AnimalDTO> toListDTO(List<Animal> animalList) {
        List<AnimalDTO> dtoList = new ArrayList<>();
        animalList.forEach(animal -> dtoList.add(toDTO(animal)));
        return dtoList;
    }
}
