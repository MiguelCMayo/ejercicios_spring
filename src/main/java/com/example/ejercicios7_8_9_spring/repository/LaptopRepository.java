package com.example.ejercicios7_8_9_spring.repository;

import com.example.ejercicios7_8_9_spring.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository <Laptop,Long> {
}
