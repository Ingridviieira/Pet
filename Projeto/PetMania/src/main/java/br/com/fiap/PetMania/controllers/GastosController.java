package br.com.fiap.PetMania.controllers;

import java.util.List;

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
import br.com.fiap.PetMania.models.GastosAnimal;
import br.com.fiap.PetMania.repository.GastosRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/gastos")
@Slf4j

public class GastosController {

    @Autowired
    GastosRepository repository;

    @GetMapping
    public List<GastosAnimal> index(){
        log.info("buscando todas os gastos");
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<GastosAnimal> create(
            @RequestBody @Valid GastosAnimal gastos,
            BindingResult result
        ){
        log.info("cadastrando gasto: " + gastos);
        repository.save(gastos);
        return ResponseEntity.status(HttpStatus.CREATED).body(gastos);
    }

    @GetMapping("{id}")
    public ResponseEntity<GastosAnimal> show(@PathVariable Long id){
        log.info("buscando gasto: " + id);
        return ResponseEntity.ok(getGastos(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GastosAnimal> destroy(@PathVariable Long id){
        log.info("apagando gasto: " + id);
        repository.delete(getGastos(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<GastosAnimal> update(
        @PathVariable Long id,
        @RequestBody @Valid GastosAnimal gastos
    ){
        log.info("atualizando gasto: " + id);
        getGastos(id);
        gastos.setId(id);
        repository.save(gastos);
        return ResponseEntity.ok(gastos);
    }

    private GastosAnimal getGastos(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new RestNotFoundException("Gasto não encontrato"));
    }
    
}
