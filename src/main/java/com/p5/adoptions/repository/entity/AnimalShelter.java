package com.p5.adoptions.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AnimalShelter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String address;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "animal_id") //foreign key...default is the getId from the child
//    private Animal animal;

//    @ManyToMany  // unidirectional relationship
//    @JoinTable(name = "animal_shelter",
//            joinColumns =
//            @JoinColumn(name = "shelter_id", referencedColumnName = "getId"),
//            inverseJoinColumns =
//            @JoinColumn(name = "animal_id", referencedColumnName = "getId")
//    )
//    private List<Animal> animals = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shelter_id")
    private List<Animal> animals = new ArrayList<>();

    public AnimalShelter() {
    }

    public Integer getId() {
        return id;
    }

    public AnimalShelter setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelter setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AnimalShelter setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public AnimalShelter setAnimals(List<Animal> animals) {
        this.animals = animals;
        return this;
    }
}
