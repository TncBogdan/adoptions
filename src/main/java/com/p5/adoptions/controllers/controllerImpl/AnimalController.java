package com.p5.adoptions.controllers.controllerImpl;

import com.p5.adoptions.services.model.AnimalDomain;
import com.p5.adoptions.repository.AnimalStore;
import com.p5.adoptions.services.serviceImpl.AnimalService;
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

    @GetMapping("/hello")
    public ResponseEntity<String> greetOwner(@RequestParam(name = "name", required = false) String ownerName)
    {
        String name = ownerName == null ? "world" : ownerName;
        return ResponseEntity.ok("Hello " + name + ", from the animal shelter!");
    }


    @GetMapping("{getId}")
    public ResponseEntity<AnimalDomain> getAnimal(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(animalService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<AnimalDomain>> getAll() {
        return ResponseEntity.ok(animalService.getAll());
    }

    @PostMapping
    public ResponseEntity<AnimalDomain> addAnimal(@RequestBody AnimalDomain animalDomain) {

        if (animalDomain == null && animalDomain.getName() == null && animalDomain.getPhoto() == null)
        {
            return ResponseEntity.badRequest().body(animalDomain);
        }
        AnimalStore.available.add(animalDomain);

//        animalService.addAnimal(animalDTO);

        return ResponseEntity.ok(animalDomain);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name = "name") String name, @RequestBody AnimalDomain updatedAnimal)
    {

        List<AnimalDomain> available = AnimalStore.available;
        for (int i = 0; i < available.size(); i++)
        {
            AnimalDomain animal = available.get(i);
            if (animal.getName().equals(name))
            {
                available.remove(i);
                available.add(updatedAnimal);
                break;
            }
        }
    }

    @DeleteMapping("/{name}")
    public void deleteAnimal(@PathVariable(name = "name") String name)
    {
        List<AnimalDomain> available = AnimalStore.available;
        for (int i = 0; i < available.size(); i++)
        {
            AnimalDomain animal = available.get(i);
            if (animal.getName().equals(name))
            {
                available.remove(i);
                break;
            }
        }
    }
}
