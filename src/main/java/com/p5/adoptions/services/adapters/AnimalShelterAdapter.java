package com.p5.adoptions.services.adapters;

import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.model.AnimalShelterDomain;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelterAdapter {

    public static AnimalShelter fromDTO(AnimalShelterDomain animalShelterDomain) {
        return new AnimalShelter()
                .setName(animalShelterDomain.getName())
                .setAddress(animalShelterDomain.getAddress())
                .setId(animalShelterDomain.getId())
                .setAnimals(AnimalAdapter.fromListDomain(animalShelterDomain.getAnimals()));
    }

    public static AnimalShelterDomain toDTO(AnimalShelter animalShelter) {
        return new AnimalShelterDomain()
                .setId(animalShelter.getId())
                .setName(animalShelter.getName())
                .setAddress(animalShelter.getAddress())
                .setAnimals(AnimalAdapter.toListDomain(animalShelter.getAnimals()));
    }

    public static List<AnimalShelterDomain> toListDTO(List<AnimalShelter> animalShelters) {
        List<AnimalShelterDomain> list = new ArrayList<>();
        animalShelters.forEach(animalShelter -> list.add(toDTO(animalShelter)));
        return list;
    }

}
