package com.p5.adoptions.controllers;

import com.p5.adoptions.repository.entity.Animal;
import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.services.AnimalShelterService;
import com.p5.adoptions.services.model.AnimalShelterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/shelters")
public class AnimalShelterController {

    private final AnimalShelterService animalShelterService;

    public AnimalShelterController(AnimalShelterService animalShelterService) {
        this.animalShelterService = animalShelterService;
    }

    @GetMapping("{id}")
    private ResponseEntity<AnimalShelterDTO>getShelter(@PathVariable("id") Integer id){
        return ResponseEntity.ok(animalShelterService.getShelter(id));
    }

    @PostMapping
    private ResponseEntity<AnimalShelterDTO>createShelter(@RequestBody AnimalShelterDTO animalShelterDTO){
        return ResponseEntity.ok(animalShelterService.createShelter(animalShelterDTO));
    }
}
