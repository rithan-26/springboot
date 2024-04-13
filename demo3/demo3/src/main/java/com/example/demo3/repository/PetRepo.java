package com.example.demo3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo3.model.Pet;

public interface PetRepo extends JpaRepository<Pet, Integer> {
    @Query("SELECT e FROM Event e WHERE e.eventPlace='Coimbatore'")
    List<Pet> findByPlace();
}
