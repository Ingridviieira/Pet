package br.com.fiap.PetMania.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Entity
public class GastosAnimal {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Categoria;
    private Double gasto;
    
	public GastosAnimal() {
		super();
	}
	public GastosAnimal(Long id, String categoria, Double gasto) {
		super();
		this.id = id;
		Categoria = categoria;
		this.gasto = gasto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public Double getGasto() {
		return gasto;
	}
	public void setGasto(Double gasto) {
		this.gasto = gasto;
	}
	@Override
	public String toString() {
		return "GastosAnimal [id=" + id + ", Categoria=" + Categoria + ", gasto=" + gasto + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Categoria, gasto, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GastosAnimal other = (GastosAnimal) obj;
		return Objects.equals(Categoria, other.Categoria) && Objects.equals(gasto, other.gasto)
				&& Objects.equals(id, other.id);
		
	}
	
	
}