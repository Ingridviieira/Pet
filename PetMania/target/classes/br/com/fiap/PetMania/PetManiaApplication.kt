package br.com.fiap.PetMania

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PetManiaApplication

fun main(args: Array<String>) {
	runApplication<PetManiaApplication>(*args)
}
