package com.p5.adoptions.repository.entity;

import javax.persistence.*;

///Option 1
//Animal will not be save in DB
//@MappedSuperclass

///Option 2
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//Specify a name for the column "discriminator"; default is the name of the class
//@DiscriminatorColumn(name = "name", discriminatorType = DiscriminatorType.STRING)

///Option 3
//One table for each entity
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)

//Option 4
//create table for each entity
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    protected String name;
    protected String photo;

    @Enumerated(EnumType.ORDINAL)
    protected BreedEnum breed;

//    @ManyToOne
//    private AnimalShelter shelter;

//    @ManyToMany(mappedBy = "animals")
//    private List<AnimalShelter>animalShelters = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "shelter_id")
    protected AnimalShelter shelter;

    public Animal() {
    }

    public AnimalShelter getShelter() {
        return shelter;
    }

    public Animal setShelter(AnimalShelter shelter) {
        this.shelter = shelter;
        return this;
    }

    public BreedEnum getBreed() {
        return breed;
    }

    public Animal setBreed(BreedEnum breed) {
        this.breed = breed;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Animal setPhoto(String photo) {
        this.photo = photo;
        return this;
    }
}
