package com.p5.adoptions.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    protected String name;
    protected String photo;

    @Enumerated(EnumType.ORDINAL)
    protected BreedEnum breed;

    @ManyToOne()
    @JoinColumn(name = "shelter_id")
    protected AnimalShelter shelter;

}
