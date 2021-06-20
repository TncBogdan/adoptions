package com.p5.adoptions.repository;

import com.p5.adoptions.services.domain.AnimalShelterDomain;
import com.p5.adoptions.repository.entity.AnimalShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalShelterRepository extends JpaRepository<AnimalShelter, Integer> {
    String findByName(String name);

    AnimalShelterDomain findByName(AnimalShelterDomain animalShelterDomain);
}
