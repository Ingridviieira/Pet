package br.com.fiap.PetMania.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.fiap.PetMania.models.Animal;
import br.com.fiap.PetMania.models.GastosAnimal;
import br.com.fiap.PetMania.repository.AnimalRepository;
import br.com.fiap.PetMania.repository.GastosRepository;

@Configuration
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner{

	@Autowired
	AnimalRepository animalRepository;

	@Autowired
	GastosRepository gastosRepository;
	
	@Override
	public void run(String... args) throws Exception {

		GastosAnimal g1 = new GastosAnimal(1L, "brinquedo", new BigDecimal(100), "Pet");
		GastosAnimal g2 = new GastosAnimal(2L, "comida",new BigDecimal(100), "Food");
		GastosAnimal g3 = new GastosAnimal(3L, "Roupa", new BigDecimal(100), "clothes");
		gastosRepository.saveAll(List.of(g1,g2,g3));


		animalRepository.saveAll(List.of(
			Animal.builder().raca("Shih tzu").nome("Snoopy").idade(2).peso(12.0).gastosAnimal(g1).build(),
			Animal.builder().raca("Yorkshire").nome("Pedro").idade(2).peso(3.4).gastosAnimal(g2).build(),
			Animal.builder().raca("Pug").nome("Bil").idade(5).peso(6.3).gastosAnimal(g3).build(),
			Animal.builder().raca("Shih tzu").nome("bob").idade(4).peso(15.0).gastosAnimal(g1).build(),
			Animal.builder().raca("Shih tzu").nome("jorge").idade(1).peso(5.9).gastosAnimal(g1).build()
		));

	}
}
		
