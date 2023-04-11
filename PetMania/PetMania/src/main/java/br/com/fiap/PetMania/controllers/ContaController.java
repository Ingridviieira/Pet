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
import br.com.fiap.PetMania.models.Conta;
import br.com.fiap.PetMania.models.Despesa;
import br.com.fiap.PetMania.repository.ContaRepository;
import br.com.fiap.PetMania.repository.DespesaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/conta")
@Slf4j
public class ContaController {

    @Autowired
    ContaRepository repository; 

    @GetMapping
    public List<Conta> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Conta> create(
            @RequestBody @Valid Conta conta, 
            BindingResult result
        ){
        log.info("Cadastro de Animais: " + conta);
        repository.save(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @GetMapping("{id}")
    public ResponseEntity<Conta> show(@PathVariable Long id){
        log.info("Buscando Animal: " + id);
        return ResponseEntity.ok(getConta(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Conta> destroy(@PathVariable Long id){
        log.info("apagando animal: " + id);
        repository.delete(getConta(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Conta> update(
        @PathVariable Long id, 
        @RequestBody @Valid Conta conta
    ){
        log.info("atualizando cadastro de animal: " + id);
        getConta(id);
        conta.setId(id);
        repository.save(conta);
        return ResponseEntity.ok(conta);
    }

    private Conta getConta(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new RestNotFoundException("Animal não encontrado"));
    }
    
}
