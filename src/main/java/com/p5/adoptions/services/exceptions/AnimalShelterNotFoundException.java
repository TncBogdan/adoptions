package com.p5.adoptions.services.exceptions;

public class AnimalShelterNotFoundException extends RuntimeException {
    public AnimalShelterNotFoundException(String message) {
        super(message);
    }
}
