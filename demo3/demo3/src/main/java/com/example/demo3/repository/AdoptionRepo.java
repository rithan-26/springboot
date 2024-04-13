package com.example.demo3.repository;

import com.example.demo3.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepo extends JpaRepository<Adoption, Long> {
    // You can add custom query methods here if needed
}
