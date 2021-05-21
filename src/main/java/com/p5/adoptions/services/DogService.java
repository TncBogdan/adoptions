package com.p5.adoptions.services;

import com.p5.adoptions.repository.DogRepository;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    private DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

}
