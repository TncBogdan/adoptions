package com.p5.adoptions.repository;

import com.p5.adoptions.model.AnimalShelterDTO;
import com.p5.adoptions.repository.entity.AnimalShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalShelterRepository extends JpaRepository<AnimalShelter, Integer> {
    String findByName(String name);

    AnimalShelterDTO findByName(AnimalShelterDTO animalShelterDTO);
}
