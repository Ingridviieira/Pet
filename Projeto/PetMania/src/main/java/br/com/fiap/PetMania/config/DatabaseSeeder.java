package br.com.fiap.PetMania.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.PetMania.models.Animal;
import br.com.fiap.PetMania.models.GastosAnimal;
import br.com.fiap.PetMania.repository.AnimalRepository;
import br.com.fiap.PetMania.repository.GastosRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

	@Autowired
	AnimalRepository animalRepository;

	@Autowired
	GastosRepository gastosRepository;
	
	@Override
	public void run(String... args) throws Exception {

		
		// Animal a1 = new Animal(id: 1L, raca:"Shih-tzu", nome: "Snoopy", genero: "Macho", idade: 2, peso: 12.0);
		// Animal a2 = new Animal(id: 2L, raca:"Siamês", nome: "Mia", genero: "Femea", idade: 1, peso: 3.8);
		// animalRepository.saveAll(List.of(a1,a2));

		// Animal a1 = new Animal(id: 1L, raca:"Shih-tzu", nome: "Snoopy", genero: "Macho",idade: 2, peso:12.0);
		// Animal a2 = new Animal(2L, "Siamês", "Mia", "Femea", 1, 3.8, null, null);
		// animalRepository.saveAll(List.of(a1, a2));

		
		GastosAnimal g1 = new GastosAnimal(1L, "brinquedo", 22.5, new BigDecimal(100), "Pet");
		GastosAnimal g2 = new GastosAnimal(2L, "comida", 10.5, new BigDecimal(100), "Food");
		GastosAnimal g3 = new GastosAnimal(3L, "Roupa", 200.50, new BigDecimal(100), "clothes");
		gastosRepository.saveAll(List.of(g1));


		animalRepository.saveAll(List.of(
			Animal.builder().raca("Shih tzu").nome("Snoopy").idade(2).peso(12.0).gastosAnimal(g1).build(),
			Animal.builder().raca("Yorkshire").nome("Pedro").idade(2).peso(3.4).gastosAnimal(g2).build(),
			Animal.builder().raca("Pug").nome("Bil").idade(5).peso(6.3).gastosAnimal(g3).build()


		));

	}

}



	// private Long id;
	// private String raca;
	// private String nome;
	// private String genero;
	// private int idade
	// private double peso;
	// private LocalDate dt_nascimento;


// gastosRepository.saveAll(List.of(
// 			new GastosAnimal(1L, "brinquedo", 22.5, new BigDecimal(100), "Pet")
			
