package com.p5.adoptions.controllers.controllerImpl;

import com.p5.adoptions.services.model.CatDomain;
import com.p5.adoptions.services.serviceImpl.CatService;
import com.p5.adoptions.services.model.ListDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<ListDomain<CatDomain>> getAllCats() {
        return ResponseEntity.ok(catService.findAll());
    }

    @PostMapping
    public void addCat(@RequestBody CatDomain catDTO) {
        catService.addCat(catDTO);
    }
}
