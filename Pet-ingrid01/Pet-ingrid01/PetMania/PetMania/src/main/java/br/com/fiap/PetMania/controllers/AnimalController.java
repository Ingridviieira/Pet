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

import br.com.fiap.PetMania.models.Animal;
import br.com.fiap.PetMania.repository.AnimalRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/Animal")
public class AnimalController {

    Logger log = LoggerFactory.getLogger(AnimalController.class);

    @Autowired
    AnimalRepository repository; 

    @GetMapping
    public List<Animal> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Animal> create( @RequestBody @Valid Animal animal, BindingResult result){
 
        log.info("cadastrando de animal: " + animal);
        repository.save(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(animal);
    }

    @GetMapping("{id}")
    public ResponseEntity<Animal> show(@PathVariable Long id){
        log.info("buscando Animal: " + id);
        var encontradoAnimal = repository.findById(id);

        if(encontradoAnimal.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(encontradoAnimal.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Animal> destroy(@PathVariable Long id){
        log.info("apagando Animal: " + id);

        var encontradoAnimal = repository.findById(id);

        if(encontradoAnimal.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.delete(encontradoAnimal.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal animal){
        log.info("editando Pet: " + id);

        var encontradoAnimal = repository.findById(id);

        if(encontradoAnimal.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    
        
        animal.setId(id);
        repository.save(animal);
        return ResponseEntity.ok(animal);
    }
    
}


