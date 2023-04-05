package br.com.fiap.PetMania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.PetMania.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    
}