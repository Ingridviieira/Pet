package br.com.fiap.PetMania.controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.PetMania.exception.RestNotFoundException;
import br.com.fiap.PetMania.models.Animal;
import br.com.fiap.PetMania.repository.AnimalRepository;
import br.com.fiap.PetMania.repository.GastosRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/Animal")

public class AnimalController {
    
    Logger log = LoggerFactory.getLogger(AnimalController.class);

    @Autowired
    AnimalRepository animalRepository; 

    @Autowired
    GastosRepository gastosRepository;

    @GetMapping
    public List<Animal> index(){
        return animalRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Animal> create( 
        @RequestBody @Valid Animal animal, 
        BindingResult result
        ){
        log.info("cadastrando de animal: " + animal);
        animalRepository.save(animal);
        animal.setGastosAnimal(gastosRepository.findById(animal.getGastosAnimal().getId()).get());
        return ResponseEntity.status(HttpStatus.CREATED).body(animal);
    }

    @GetMapping("{id}")
    public ResponseEntity<Animal> show(
        @PathVariable Long id
        ){
        log.info("Buscando Animal: " + id);
        return ResponseEntity.ok(getAnimal(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Animal> destroy(
        @PathVariable Long id
        ){
        log.info("Apagando Animal: " + id);
        animalRepository.delete(getAnimal(id));
        return ResponseEntity.ok(getAnimal(id));  
    }

    @PutMapping("{id}")
    public ResponseEntity<Animal> update(
        @PathVariable Long id, 
        @RequestBody Animal animal
        ){
        log.info("Editando animal: " + id);
        getAnimal(id);
        animal.setId(id);
        animalRepository.save(animal);
        return ResponseEntity.ok(animal);
        }

        private Animal getAnimal(Long id) {
            return animalRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("Animal não encontrado"));
        }
}


