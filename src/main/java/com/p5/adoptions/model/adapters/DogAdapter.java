package com.p5.adoptions.model.adapters;

import com.p5.adoptions.repository.entity.Dog;
import com.p5.adoptions.model.DogDTO;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter {

    public static Dog fromDTO(DogDTO dogDTO){
        return (Dog) new Dog().setId(dogDTO.getId()).setName(dogDTO.getName()).setPhoto(dogDTO.getPhoto());
    }

    public static DogDTO toDTO(Dog dog){
        return new DogDTO(dog.getId(), dog.getName(), dog.getPhoto());
    }

    public static List<DogDTO> toListDTO(List<Dog>dogList){
        List<DogDTO>dogDTOList = new ArrayList<>();
        dogList.forEach(dog -> dogDTOList.add(toDTO(dog)));
        return dogDTOList;
    }
}
