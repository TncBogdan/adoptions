package com.p5.adoptions.services.serviceImpl;

import com.p5.adoptions.repository.repositoryInterfaces.DogRepository;
import com.p5.adoptions.services.model.DogDomain;
import com.p5.adoptions.services.adapters.DogAdapter;
import com.p5.adoptions.services.model.ListDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    private DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public void addDog(DogDomain dogDTO) {
        if (dogDTO.getName() == null && dogDTO.getPhoto() == null) {
            throw new RuntimeException("Must have name and url.");
        }
        dogRepository.save(DogAdapter.fromDTO(dogDTO));
    }

    public ListDomain<DogDomain> findAll() {
        List<DogDomain> dogDTOList = DogAdapter.toListDTO(dogRepository.findAll());
        long totalCount = dogRepository.count();
        return new ListDomain<>(Math.toIntExact(totalCount), dogDTOList);
    }

    public DogDomain findDogByName(String name) {
        if (name == null) {
            throw new RuntimeException("Must have a name.");
        }
        return DogAdapter.toDTO(dogRepository.findDogByName(name));
    }
}
