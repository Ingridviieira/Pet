package br.com.fiap.PetMania.config;

//ADC ao banco de dados os animais 

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.PetMania.models.ContaAnimal;
import br.com.fiap.PetMania.repository.ContaAnimalRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ContaAnimalRepository contaRepository;

    @Override
    public void run(String... args) throws Exception {

        contaRepository.saveAll(List.of(
            new Conta(1,"Labrador", "Kira", "Fêmea", "2.3"), 
            new Conta(2,"Chihuahua" ,"Bingo", "Macho", "4.6"), 
            
        ));
    }
    
}
