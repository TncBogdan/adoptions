package com.p5.adoptions.repository.repositoryInterfaces;

import com.p5.adoptions.repository.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
     Cat findCatByName(String name);
}
