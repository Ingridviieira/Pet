package br.com.fiap.PetMania.repository;

import br.com.fiap.PetMania.models.Animal;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Page<Animal> findByNomeContaining(String busca, Pageable pageable);

}
//findByDescricaoContaining(String busca, Pageable pageable);
