package com.p5.adoptions.controllers;

import com.p5.adoptions.repository.Cat;
import com.p5.adoptions.services.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getAllCats(){
        List<Cat> catsList = catService.findAll();
        return ResponseEntity.ok(catsList);
    }

    @PostMapping
    public void addCat(@RequestBody Cat cat){
        catService.addCat(cat);
    }
}
