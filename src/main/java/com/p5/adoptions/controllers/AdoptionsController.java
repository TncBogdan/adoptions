package com.p5.adoptions.controllers;

import com.p5.adoptions.model.Animal;
import com.p5.adoptions.model.repository.AnimalStore;
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
    public ResponseEntity<List<Animal>>getAvailableAnimal(){
        return ResponseEntity.ok(AnimalStore.available);
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimalForAdoptions(@RequestBody Animal animal){
        if (animal == null && animal.getName() == null && animal.getPhotoUrl() == null){
            return ResponseEntity.badRequest().body(animal);
        }
        AnimalStore.available.add(animal);
        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name = "name") String name, @RequestBody Animal updateAnimal){
        List<Animal> availeble = AnimalStore.available;
        for (int i = 0; i < availeble.size(); i++) {
            Animal animal = availeble.get(i);
            if (animal.getName().equals(name)){
                availeble.remove(i);
                availeble.add(updateAnimal);
                break;
            }
        }
    }

    @DeleteMapping("{/name}")
    public void deleteAnimal(@PathVariable(name = "name") String name){
        List<Animal> availeble = AnimalStore.available;
        for (int i = 0; i < availeble.size(); i++) {
            Animal animal = availeble.get(i);
            if (animal.getName().equals(name)){
                availeble.remove(i);
                break;
            }
        }
    }
}
