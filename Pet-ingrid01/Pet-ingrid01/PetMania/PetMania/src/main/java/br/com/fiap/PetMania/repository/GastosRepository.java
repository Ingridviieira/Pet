package br.com.fiap.PetMania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.PetMania.models.GastosAnimal;

public interface GastosRepository extends JpaRepository<GastosAnimal, Long>{

}
