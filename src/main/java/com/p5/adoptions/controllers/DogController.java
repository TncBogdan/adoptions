package com.p5.adoptions.controllers;

import com.p5.adoptions.services.DogService;
import com.p5.adoptions.services.model.DogDTO;
import com.p5.adoptions.services.model.ListDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/dogs")
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<ListDTO<DogDTO>> getAllDogs(){
        return ResponseEntity.ok(dogService.findAll());
//        return DogAdapter.toListDTO(dogList);
    }

    @PostMapping
    public void add(@RequestBody DogDTO dogDTO){
        dogService.addDog(dogDTO);
    }

}
