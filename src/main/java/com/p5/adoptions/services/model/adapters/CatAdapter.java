package com.p5.adoptions.services.model.adapters;

import com.p5.adoptions.repository.entity.Cat;
import com.p5.adoptions.services.model.CatDTO;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter {

    public static Cat fromDTO(CatDTO catDTO) {
        return (Cat) new Cat().setName(catDTO.getName()).setPhoto(catDTO.getPhoto());

    }

    public static CatDTO toDTO(Cat cat) {
        return new CatDTO(cat.getId(), cat.getName(), cat.getPhoto());
    }

    public static List<CatDTO> toListDTO(List<Cat> catList) {
        List<CatDTO> dtoList = new ArrayList<>();
        catList.forEach(cat -> dtoList.add(toDTO(cat)));
        return dtoList;
    }
}
