package br.com.fiap.PetMania.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

@Entity
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
	private String nome;
	@NotBlank @Max( value= 7, message = "O genero deve ter no maximo 5 letra para femea ou macho")
	private String genero;
	private int idade;
	private double peso;
	private LocalDate dt_nascimento;

	public Animal(Long id, String raca, String nome, String genero, int idade, double peso, LocalDate dt_nascimento) {
		super();
		this.id = id;
		this.raca = raca;
		this.nome = nome;
		this.genero = genero;
		this.idade = idade;
		this.peso = peso;
		this.dt_nascimento = dt_nascimento;
	}

	public Animal() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public LocalDate getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(LocalDate dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", raca=" + raca + ", nome=" + nome + ", genero=" + genero + ", idade=" + idade
				+ ", peso=" + peso + ", dt_nascimento=" + dt_nascimento + "]";
	}
	
}