package com.p5.adoptions.controllers;

import com.p5.adoptions.services.AnimalService;
import com.p5.adoptions.model.AnimalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("{id}")
    public ResponseEntity<AnimalDTO> getAnimal(@PathVariable("id") Integer id){
        return ResponseEntity.ok(animalService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAll(){
        return ResponseEntity.ok(animalService.getAll());
    }

//    @PostMapping
//    public ResponseEntity<AnimalDTO>addAnimal(@RequestBody AnimalDTO animalDTO, AnimalShelter animalShelter){
//
//        return ResponseEntity.ok(animalService.addAnimal(animalDTO));
//    }
}
