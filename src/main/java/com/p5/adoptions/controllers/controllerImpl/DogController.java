package com.p5.adoptions.controllers.controllerImpl;

import com.p5.adoptions.services.serviceImpl.DogService;
import com.p5.adoptions.services.model.DogDomain;
import com.p5.adoptions.services.model.ListDomain;
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
    public ResponseEntity<ListDomain<DogDomain>> getAllDogs(){
        return ResponseEntity.ok(dogService.findAll());
//        return DogAdapter.toListDTO(dogList);
    }

    @PostMapping
    public void add(@RequestBody DogDomain dogDTO){
        dogService.addDog(dogDTO);
    }

}
