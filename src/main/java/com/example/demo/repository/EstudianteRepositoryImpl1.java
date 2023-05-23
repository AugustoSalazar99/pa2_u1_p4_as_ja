package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Estudiante;

@Repository
public class EstudianteRepositoryImpl1 implements EstudianteRepository {

	private static List<Estudiante> baseDatos = new ArrayList<>();

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		baseDatos.add(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// encuentro el metodo actual, remuevo el actual y luego pongo el nuevo metodo
		// Estudiante estu = this.seleccionar(estudiante.getCedula());
		this.eliminar(estudiante.getCedula());
		this.insertar(estudiante);

	}

	@Override
	public Estudiante seleccionar(String cedula) {
		Estudiante estuEncontrado = new Estudiante();
		for (Estudiante estu : baseDatos) {

			if (cedula.equals(estu.getCedula())) {
				estuEncontrado = estu;

			}

		}
		return estuEncontrado;
	}

	@Override
	// para reutilizar un objeto se utiliza el this
	public void eliminar(String cedula) {
		Estudiante estu = this.seleccionar(cedula);
		baseDatos.remove(estu);
	}

	@Override
	public List<Estudiante> seleccionarTodos() {
		return baseDatos;
	}

}
