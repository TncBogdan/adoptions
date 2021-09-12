package com.p5.adoptions.services.adapters;

import com.p5.adoptions.repository.entity.Cat;
import com.p5.adoptions.services.model.CatDomain;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter {

    public static Cat fromDTO(CatDomain catDTO) {
        return (Cat) new Cat().setName(catDTO.getName())
                .setPhoto(catDTO.getPhoto());

    }

    public static CatDomain toDTO(Cat cat) {
        return new CatDomain(cat.getId(), cat.getName(), cat.getPhoto());
    }

    public static List<CatDomain> toListDTO(List<Cat> catList) {
        List<CatDomain> dtoList = new ArrayList<>();
        catList.forEach(cat -> dtoList.add(toDTO(cat)));
        return dtoList;
    }
}
