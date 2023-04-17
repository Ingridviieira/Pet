package br.com.fiap.PetMania.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.PetMania.models.GastosAnimal;
import br.com.fiap.PetMania.repository.GastosRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

	@Autowired
	GastosRepository gastosRepository;
	
	@Override
	public void run(String... args) throws Exception {
		gastosRepository.saveAll(List.of(
			new GastosAnimal(1L, "brinquedo", 22.5, new BigDecimal(100), "Pet")
			
		));
	}

}
