package com.p5.adoptions.services.serviceImpl;

import com.p5.adoptions.repository.repositoryInterfaces.CatRepository;
import com.p5.adoptions.services.model.CatDomain;
import com.p5.adoptions.services.adapters.CatAdapter;
import com.p5.adoptions.services.model.ListDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void addCat(CatDomain catDTO) {
        if (catDTO.getName() == null && catDTO.getPhoto() == null) {
            throw new RuntimeException("Must have a name and a photo.");
        }
        catRepository.save(CatAdapter.fromDTO(catDTO));
    }

    public ListDomain<CatDomain> findAll() {
        List<CatDomain> catDTOList = CatAdapter.toListDTO(catRepository.findAll());
        long totalCount = catRepository.count();
        return new ListDomain<>(Math.toIntExact(totalCount), catDTOList);
    }

    public CatDomain findCat(String name) {
        if (name == null && name.equals("")) {
            throw new RuntimeException("Must have a name.");
        }
        return CatAdapter.toDTO(catRepository.findCatByName(name));
    }
}
