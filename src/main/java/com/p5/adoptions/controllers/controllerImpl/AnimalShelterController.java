package com.p5.adoptions.controllers.controllerImpl;

import com.p5.adoptions.services.serviceImpl.AnimalShelterService;
import com.p5.adoptions.services.model.AnimalShelterDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/shelters")
public class AnimalShelterController {

    private final AnimalShelterService animalShelterService;

    public AnimalShelterController(AnimalShelterService animalShelterService) {
        this.animalShelterService = animalShelterService;
    }

    @GetMapping
    private ResponseEntity<List<AnimalShelterDomain>>getAll(){
        return ResponseEntity.ok(animalShelterService.getAll());
    }

    @GetMapping("{getId}")
    private ResponseEntity<AnimalShelterDomain>getShelter(@PathVariable("id") Integer id){
        return ResponseEntity.ok(animalShelterService.getShelter(id));
    }

    @PostMapping
    private ResponseEntity<AnimalShelterDomain>createShelter(@Valid @RequestBody AnimalShelterDomain animalShelterDomain){
        return ResponseEntity.ok(animalShelterService.createShelter(animalShelterDomain));
    }

    @PutMapping
    private ResponseEntity<AnimalShelterDomain>updateShelter(@Valid @RequestBody AnimalShelterDomain animalShelterDomain){
        return ResponseEntity.ok(animalShelterService.updateShelter(animalShelterDomain));
    }

//    @PatchMapping
//    private ResponseEntity<AnimalDTO> patchAnimalShelter(@RequestBody AnimalShelterDTO animalShelterDTO, AnimalDTO animalDTO){
//        return ResponseEntity.ok(animalShelterService.addAnimalToSpecificShelter(animalShelterDTO, animalDTO));
//    }
}