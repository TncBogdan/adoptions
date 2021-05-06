package com.p5.adoptions.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/animals")
public class AdoptionsController {

    //    @RequestMapping(method = RequestMethod.GET, value = "hello") /// old way
    @GetMapping("/hello")
    public ResponseEntity<String> greetOwner(@RequestParam(name = "name", required = false) String ownerName) {

        String name = ownerName == null ? "world" : ownerName;
        return ResponseEntity.ok("Hello " + name + ", from the animal shelter!");
    }
}
