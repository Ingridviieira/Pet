package br.com.fiap.PetMania.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.PetMania.models.Animal;
import br.com.fiap.PetMania.repository.AnimalRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

	@Autowired
	AnimalRepository animalRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		animalRepository.saveAll(List.of(
//		new Animal(1l, "labrado", "Kira", "femea", 1, 8.5, LocalDate.now()),
//		new Animal(2l, "golden", "Rex", "Macho", 3, 12.5, LocalDate.now())
//		));
	}

}
