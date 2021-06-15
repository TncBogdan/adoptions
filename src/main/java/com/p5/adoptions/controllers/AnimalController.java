package com.p5.adoptions.controllers;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.repository.AnimalStore;
import com.p5.adoptions.services.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
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


    @GetMapping("{id}")
    public ResponseEntity<AnimalDTO> getAnimal(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(animalService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAll() {
        return ResponseEntity.ok(animalService.getAll());
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> addAnimal(@RequestBody AnimalDTO animalDTO) {

        if (animalDTO == null && animalDTO.getName() == null && animalDTO.getPhoto() == null)
        {
            return ResponseEntity.badRequest().body(animalDTO);
        }
        AnimalStore.available.add(animalDTO);

//        animalService.addAnimal(animalDTO);

        return ResponseEntity.ok(animalDTO);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name = "name") String name, @RequestBody AnimalDTO updatedAnimal)
    {

        List<AnimalDTO> available = AnimalStore.available;
        for (int i = 0; i < available.size(); i++)
        {
            AnimalDTO animal = available.get(i);
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
        List<AnimalDTO> available = AnimalStore.available;
        for (int i = 0; i < available.size(); i++)
        {
            AnimalDTO animal = available.get(i);
            if (animal.getName().equals(name))
            {
                available.remove(i);
                break;
            }
        }
    }
}
