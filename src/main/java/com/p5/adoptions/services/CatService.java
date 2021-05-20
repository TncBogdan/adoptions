package com.p5.adoptions.services;

import com.p5.adoptions.repository.CatRepository;
import com.p5.adoptions.services.model.CatDTO;
import com.p5.adoptions.services.model.adapters.CatAdapter;
import com.p5.adoptions.services.model.adapters.ListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void addCat(CatDTO catDTO) {
        if (catDTO.getName() == null && catDTO.getPhoto() == null) {
            throw new RuntimeException("Cat must have a name and a photo.");
        }
        catRepository.save(CatAdapter.toCat(catDTO));
    }

    public ListDTO<CatDTO> findAll() {
        List<CatDTO> catDTOList = CatAdapter.toListDTO(catRepository.findAll());
        long totalCount = catRepository.count();
        return new ListDTO<CatDTO>(Math.toIntExact(totalCount), catDTOList);
    }

    public CatDTO findCat(String name) {
        if (name == null && name.equals("")) {
            throw new RuntimeException("Must have name.");
        }
        return CatAdapter.toDTO(catRepository.findCatByName(name));
    }
}
