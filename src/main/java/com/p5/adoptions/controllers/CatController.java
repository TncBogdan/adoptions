package com.p5.adoptions.controllers;

import com.p5.adoptions.services.model.CatDTO;
import com.p5.adoptions.services.CatService;
import com.p5.adoptions.services.model.adapters.ListDTO;
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
    public ResponseEntity<ListDTO<CatDTO>> getAllCats() {
        return ResponseEntity.ok(catService.findAll());
    }

    @PostMapping
    public void addCat(@RequestBody CatDTO catDTO) {
        catService.addCat(catDTO);
    }
}
