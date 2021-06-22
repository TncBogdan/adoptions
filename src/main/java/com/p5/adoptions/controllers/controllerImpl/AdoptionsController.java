package com.p5.adoptions.controllers.controllerImpl;

import com.p5.adoptions.services.model.AnimalDomain;
import com.p5.adoptions.repository.AnimalStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/adoptions")
public class AdoptionsController {

    //    @RequestMapping(method = RequestMethod.GET, value = "hello") /// old way
    @GetMapping("/hello")
    public ResponseEntity<String> greetOwner(@RequestParam(name = "name", required = false) String ownerName) {
        String name = ownerName == null ? "world" : ownerName;
        return ResponseEntity.ok("Hello " + name + ", from the animal shelter!");
    }

    @GetMapping
    public ResponseEntity<List<AnimalDomain>> getAvailableAnimal() {
        return ResponseEntity.ok(AnimalStore.available);
    }

    @PostMapping
    public ResponseEntity<AnimalDomain> addAnimalForAdoptions(@RequestBody AnimalDomain animalDomain) {
        if (animalDomain == null && animalDomain.getName() == null && animalDomain.getPhoto() == null) {
            return ResponseEntity.badRequest().body(animalDomain);
        }
        AnimalStore.available.add(animalDomain);
        return ResponseEntity.ok(animalDomain);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name = "name") String name, @RequestBody AnimalDomain updateAnimalDomain) {
        List<AnimalDomain> availeble = AnimalStore.available;
        for (int i = 0; i < availeble.size(); i++) {
            AnimalDomain animalDomain = availeble.get(i);
            if (animalDomain.getName().equals(name)) {
                availeble.remove(i);
                availeble.add(updateAnimalDomain);
                break;
            }
        }
    }

    @DeleteMapping("{/name}")
    public void deleteAnimal(@PathVariable(name = "name") String name) {
        List<AnimalDomain> availeble = AnimalStore.available;
        for (int i = 0; i < availeble.size(); i++) {
            AnimalDomain animalDomain = availeble.get(i);
            if (animalDomain.getName().equals(name)) {
                availeble.remove(i);
                break;
            }
        }
    }
}
