package br.com.fiap.PetMania.models;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;


import br.com.fiap.PetMania.controllers.AnimalController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Animal {
	/*
	 *{ "Genero": 'Fêmea',
	 * "Raça": 'Labrador',
	 *  "animal_id": 1, 
	 *  "nome": 'Kira',
	 * "dt nascimento": '2022-12-24',
	 *  "peso": '2,3 kgs',
	 *   "idade": '3 meses'
	 *   }
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank @Min( value= 4, message= "A raça deve ter no minino 4 letras")
	private String raca;

	@NotEmpty(message = "O campo nome não pode ser vazio")
	private String nome;

	@NotBlank @Max( value= 7, message = "O genero deve ter no maximo 5 letra para femea ou macho")
	private String genero;

	@Min(value = 0, message = "A idade não deve ser inferior a 0")
	private int idade;

	@Min(value = 0, message = "O peso do animal não pode ser inferior a 0")
	private double peso;
	
	@NotNull @Past
	private LocalDate dt_nascimento;

	@ManyToOne
    private GastosAnimal gastosAnimal;

	public EntityModel<Animal> toEntityModel() {
        return EntityModel.of(
            this, 
            linkTo(methodOn(AnimalController.class).show(id)).withSelfRel(),
            linkTo(methodOn(AnimalController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(AnimalController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(AnimalController.class).show(this.getGastosAnimal().getId())).withRel("Gastos_do_Animal")
        );
    }
}



	