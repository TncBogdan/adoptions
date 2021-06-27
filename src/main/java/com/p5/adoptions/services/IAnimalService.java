package com.p5.adoptions.services;

import com.p5.adoptions.services.model.AnimalDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAnimalService {

    AnimalDomain get(Integer id);

    List<AnimalDomain> getAll();

    AnimalDomain add(AnimalDomain animalDomain);
}
