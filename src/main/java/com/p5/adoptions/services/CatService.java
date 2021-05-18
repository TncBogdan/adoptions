package com.p5.adoptions.services;

import com.p5.adoptions.repository.Cat;
import com.p5.adoptions.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void addCat(Cat cat) {
        if (cat.getName() == null && cat.getPhoto() == null) {
            throw new RuntimeException("Cat must have a name and a photo.");
        }
        Cat catToSave = new Cat().setName(cat.getName())
                .setPhoto(cat.getPhoto());
        catRepository.save(catToSave);
    }

    public List<Cat> findAll() {
        return catRepository.findAll();
    }
}
