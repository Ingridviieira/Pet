package br.com.fiap.PetMania.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.PetMania.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    
}
