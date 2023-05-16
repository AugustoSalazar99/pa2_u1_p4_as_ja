package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4AsJaApplication implements  CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AsJaApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Mi primer proyecto");
		/*
		 * Spring Framework: framework que permite la construccion/ 
		 * desarrollo de aplicaciones empresariales basadas en Spring
		 */
		
		Profesor profe = new Profesor();
		profe.setApellido("Salazar");
		profe.setCedula("17258954");
		profe.setFechaNacimiento(LocalDateTime.now());
		profe.setNombre("Augusto");
		
		System.out.println(profe);
	}

}
