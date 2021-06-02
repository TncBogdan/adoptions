package com.p5.adoptions.services.model.adapters;

import com.p5.adoptions.repository.entity.Animal;
import com.p5.adoptions.services.model.AnimalDTO;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter {
    public static Animal fromDTO(AnimalDTO animalDTO){
        return (Animal) new Animal().setName(animalDTO.getName())
                .setPhoto(animalDTO.getPhoto());
    }

    public static List<Animal> fromListDTO(List<AnimalDTO> animalDTOS){
        List<Animal>animals = new ArrayList<>();
        for (AnimalDTO animal : animalDTOS){
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
