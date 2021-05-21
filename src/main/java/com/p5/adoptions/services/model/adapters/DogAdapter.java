package com.p5.adoptions.services.model.adapters;

import com.p5.adoptions.repository.entity.Dog;
import com.p5.adoptions.services.model.DogDTO;

import java.util.List;

public class DogAdapter {

    public static DogDTO toDTO(Dog dog){
        return new DogDTO(dog.getId(), dog.getName(), dog.getPhoto());
    }

    public static Dog toDog(DogDTO dogDTO){
        return new Dog().setId(dogDTO.getId()).setName(dogDTO.getName()).setPhoto(dogDTO.getPhoto());
    }

//    public static List<DogDTO> toListDTO(List<Dog>dogList){
//
//    }
}
