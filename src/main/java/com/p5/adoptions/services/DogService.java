package com.p5.adoptions.services;

import com.p5.adoptions.repository.DogRepository;
import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.adapters.DogAdapter;
import com.p5.adoptions.model.ListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    private DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public void addDog(DogDTO dogDTO) {
        if (dogDTO.getName() == null && dogDTO.getPhoto() == null) {
            throw new RuntimeException("Must have name and url.");
        }
        dogRepository.save(DogAdapter.fromDTO(dogDTO));
    }

    public ListDTO<DogDTO> findAll() {
        List<DogDTO> dogDTOList = DogAdapter.toListDTO(dogRepository.findAll());
        long totalCount = dogRepository.count();
        return new ListDTO<>(Math.toIntExact(totalCount), dogDTOList);
    }

    public DogDTO findDogByName(String name) {
        if (name == null) {
            throw new RuntimeException("Must have a name.");
        }
        return DogAdapter.toDTO(dogRepository.findDogByName(name));
    }
}
