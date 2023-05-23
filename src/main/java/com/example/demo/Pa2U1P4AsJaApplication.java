package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4AsJaApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AsJaApplication.class, args);

	}

	@Override

	public void run(String... args) throws Exception {
		Estudiante miEstudiante = new Estudiante();
		miEstudiante.setApellido("Salazar");
		miEstudiante.setCedula("23135487");
		miEstudiante.setNombre("Jhon");
		miEstudiante.setFechaNacimiento(LocalDateTime.of(1989, 07, 07, 10, 50));
		
		Estudiante miEstudiante1 = new Estudiante();
		miEstudiante1.setApellido("Arteaga");
		miEstudiante1.setCedula("231233487");
		miEstudiante1.setNombre("Augusto");
		miEstudiante1.setFechaNacimiento(LocalDateTime.of(1999, 07, 07, 11, 50));
		
		//1.guardar
		this.estudianteService.guardar(miEstudiante);
		this.estudianteService.guardar(miEstudiante1);
		
		
		
		//5. imprimir reporte
		List<Estudiante> reporte=this.estudianteService.reporteDeTodos();
		System.out.println(">>Reporte de todos los estudiantes");
		for(Estudiante estu : reporte) {
			System.out.println(estu);
		}
		//2. Actualizar
		miEstudiante1.setApellido("Salazar");
		this.estudianteService.actualizar(miEstudiante1);
		
		//reporte actualizado
		List<Estudiante> reporte2=this.estudianteService.reporteDeTodos();
		System.out.println(">>Reporte 2 de todos los estudiantes");
		for(Estudiante estu : reporte2) {
			System.out.println(estu);
		}
		
		// 3. Eliminar
		this.estudianteService.borrar("23135487");
		//Reporte 3
		List<Estudiante> reporte3=this.estudianteService.reporteDeTodos();
		System.out.println(">>Reporte 3 de todos los estudiantes");
		for(Estudiante estu : reporte3) {
			System.out.println(estu);
		}
		//4. busqueda por cedula
		System.out.println(this.estudianteService.buscarPorCedula("231233487"));
		
		
		
		
		
		//busqueda por cedula q no existe
		System.out.println(this.estudianteService.buscarPorCedula("23135487"));
		
		
		
	}

}
