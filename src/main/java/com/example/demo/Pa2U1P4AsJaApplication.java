package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4AsJaApplication implements  CommandLineRunner {
	
	//inyecion de injdeoendencia
	@Autowired
	private Profesor profe2;

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
		
		
		//orden de que se compila 
		profe.setApellido("velez");
		System.out.println(profe);
		
		
		//aqui si tenemos  null cuando se comenta a profesor.setapellido
		System.out.println(profe.getApellido());
		
		//Creando a instacia ya exites el metodo 
		//profe2 = new Profesor();
		
		//NullPointerException sale null estoyaccediendo a un metodo null cuando ni siquiera existe el objeto
		System.out.println(profe2);
		profe2.setApellido("silver");
		System.out.println(profe2.getApellido());
		System.out.println(profe.getNombre());
		
		Profesor profe3 = new Profesor();
		//estamos asignado en la direcion de memoria al profe
		profe3 = profe;
		System.out.println(profe3);
		profe.setApellido("Arteaga");
		System.out.println(profe3);
		
		MatriculaCalculo mat=new  MatriculaCalculo();
		mat.realizarmatricula("1");
		
	}

}
