package br.com.fiap.PetMania.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GastosAnimal {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome da categoria é obrigatório")
    private String Categoria;
    
	@Min(value = 0, message = "O saldo não pode ser negativo")
    private BigDecimal saldoInicial;

    private String icone;

     /*
     EXEMPLO 
     Categoria: brinquedo 
     Gasto -- preço no caso: 22.5 
     */
}