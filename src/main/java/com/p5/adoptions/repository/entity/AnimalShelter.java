package com.p5.adoptions.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class AnimalShelter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String address;

    @OneToMany()
    private List<Animal> animals = new ArrayList<>();

    public AnimalShelter() {
    }
}
