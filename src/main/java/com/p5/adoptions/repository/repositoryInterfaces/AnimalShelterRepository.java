package com.p5.adoptions.repository.repositoryInterfaces;

import com.p5.adoptions.services.model.AnimalShelterDomain;
import com.p5.adoptions.repository.entity.AnimalShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalShelterRepository extends JpaRepository<AnimalShelter, Integer> {
    String findByName(String name);

    AnimalShelterDomain findByName(AnimalShelterDomain animalShelterDomain);
}
