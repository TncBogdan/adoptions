package com.p5.adoptions.controllers;

import com.p5.adoptions.services.model.AnimalDTO;
import com.p5.adoptions.repository.AnimalStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
public class AdoptionsController {

    //    @RequestMapping(method = RequestMethod.GET, value = "hello") /// old way
    @GetMapping("/hello")
    public ResponseEntity<String> greetOwner(@RequestParam(name = "name", required = false) String ownerName) {
        String name = ownerName == null ? "world" : ownerName;
        return ResponseEntity.ok("Hello " + name + ", from the animal shelter!");
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAvailableAnimal() {
        return ResponseEntity.ok(AnimalStore.available);
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> addAnimalForAdoptions(@RequestBody AnimalDTO animalDTO) {
        if (animalDTO == null && animalDTO.getName() == null && animalDTO.getPhoto() == null) {
            return ResponseEntity.badRequest().body(animalDTO);
        }
        AnimalStore.available.add(animalDTO);
        return ResponseEntity.ok(animalDTO);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name = "name") String name, @RequestBody AnimalDTO updateAnimalDTO) {
        List<AnimalDTO> availeble = AnimalStore.available;
        for (int i = 0; i < availeble.size(); i++) {
            AnimalDTO animalDTO = availeble.get(i);
            if (animalDTO.getName().equals(name)) {
                availeble.remove(i);
                availeble.add(updateAnimalDTO);
                break;
            }
        }
    }

    @DeleteMapping("{/name}")
    public void deleteAnimal(@PathVariable(name = "name") String name) {
        List<AnimalDTO> availeble = AnimalStore.available;
        for (int i = 0; i < availeble.size(); i++) {
            AnimalDTO animalDTO = availeble.get(i);
            if (animalDTO.getName().equals(name)) {
                availeble.remove(i);
                break;
            }
        }
    }
}
