package com.p5.adoptions.services.adapters;

import com.p5.adoptions.repository.entity.Dog;
import com.p5.adoptions.services.model.DogDomain;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter {

    public static Dog fromDTO(DogDomain dogDTO){
        return (Dog) new Dog().setId(dogDTO.getId()).setName(dogDTO.getName()).setPhoto(dogDTO.getPhoto());
    }

    public static DogDomain toDTO(Dog dog){
        return new DogDomain(dog.getId(), dog.getName(), dog.getPhoto());
    }

    public static List<DogDomain> toListDTO(List<Dog>dogList){
        List<DogDomain>dogDTOList = new ArrayList<>();
        dogList.forEach(dog -> dogDTOList.add(toDTO(dog)));
        return dogDTOList;
    }
}
