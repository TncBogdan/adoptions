package com.p5.adoptions.unit;

import com.p5.adoptions.repository.entity.AnimalShelter;
import com.p5.adoptions.repository.repositoryInterfaces.AnimalShelterRepository;
import com.p5.adoptions.services.adapters.AnimalShelterAdapter;
import com.p5.adoptions.services.model.AnimalShelterDomain;
import com.p5.adoptions.services.serviceImpl.AnimalShelterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
@ExtendWith(MockitoExtension.class)
public class ShelterServiceImplTest {

    public AnimalShelterDomain shelterDomain;
    public AnimalShelter shelterJPA;

    @BeforeEach
    public void setUp() {
        this.shelterDomain = new AnimalShelterDomain()
                .setId(123)
                .setName("Visan")
                .setAddress("Iasi")
                .setAnimals(Collections.emptyList());
        this.shelterJPA = AnimalShelterAdapter.fromDTO(shelterDomain);
    }

    @Test
    public void validateShelter() {
        var shelterService = new AnimalShelterService(null);
        shelterService.validateShelter(shelterDomain);
    }

    @Test
    public void createShelterAndSaveDB() {


        var shelterRepositoryMock = Mockito.mock(AnimalShelterRepository.class);

        var shelterService = new AnimalShelterService(shelterRepositoryMock);

        Mockito.when(shelterRepositoryMock.save(Mockito.any())).thenReturn(shelterJPA);

        AnimalShelterDomain savedShelter = shelterService.add(shelterDomain);

        Assertions.assertNotNull(savedShelter);
        Assertions.assertEquals(savedShelter, shelterDomain);
    }
}
