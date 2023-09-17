package br.com.fiap.PetMania.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.PetMania.exception.RestNotFoundException;
import br.com.fiap.PetMania.models.Animal;
import br.com.fiap.PetMania.repository.AnimalRepository;
import br.com.fiap.PetMania.repository.GastosRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/Animal")
@Slf4j
@SecurityRequirement(name = "bearer-key")
@Tag(name = "animal")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    GastosRepository gastosRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 5) Pageable pageable) {
        var animal = (busca == null) ?
            animalRepository.findAll(pageable):
            animalRepository.findByNomeContaining(busca, pageable);

        return assembler.toModel(animal.map(Animal::toEntityModel));
    }

    @PostMapping
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "o animal foi cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "os dados enviados são inválidos")
    })
    public ResponseEntity<EntityModel<Animal>> create(
        @RequestBody @Valid Animal animal,
        BindingResult result){
        log.info("cadastrando de animal: " + animal);
        animalRepository.save(animal);
        animal.setGastosAnimal(gastosRepository.findById(animal.getGastosAnimal().getId()).get());
        return ResponseEntity
        .created(animal.toEntityModel().getRequiredLink("self").toUri())
        .body(animal.toEntityModel());
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Detalhes do animal",
        description = "Retornar os dados do animal de acordo com o id informado no path"
    )
    public EntityModel<Animal> show(
        @PathVariable Long id){
        log.info("Buscando Animal: " + id);
        return getAnimal(id).toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Animal> destroy(
        @PathVariable Long id){
        log.info("Apagando Animal: " + id);
        animalRepository.delete(getAnimal(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Animal> update(
        @PathVariable Long id,
        @RequestBody @Valid Animal animal){
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