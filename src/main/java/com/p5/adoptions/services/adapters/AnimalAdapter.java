package com.p5.adoptions.services.adapters;

import com.p5.adoptions.services.domain.AnimalDomain;
import com.p5.adoptions.repository.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter {
    public static Animal fromDomain(AnimalDomain animalDomain) {
        return new Animal()
                .setName(animalDomain.getName())
                .setPhoto(animalDomain.getPhoto())
                .setBreed(animalDomain.getBreed())
                .setShelter(animalDomain.getShelter());
    }

    public static List<Animal> fromListDomain(List<AnimalDomain> animalDomains) {
        List<Animal> animals = new ArrayList<>();
        for (AnimalDomain animal : animalDomains) {
            animals.add(fromDomain(animal));
        }
        return animals;
    }

    public static AnimalDomain toDomain(Animal animal) {
        return new AnimalDomain(animal.getId(), animal.getName(), animal.getPhoto(), animal.getBreed(), animal.getShelter());
    }

    public static List<AnimalDomain> toListDomain(List<Animal> animalList) {
        List<AnimalDomain> dtoList = new ArrayList<>();
        animalList.forEach(animal -> dtoList.add(toDomain(animal)));
        return dtoList;
    }
}
