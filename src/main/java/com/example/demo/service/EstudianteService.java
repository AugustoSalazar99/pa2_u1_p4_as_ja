package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteService {
	// los nombres sabor a negocio
	// methCRUD en sabor de negocio

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public Estudiante buscarPorCedula(String cedula);

	public void borrar(String cedula);

	public List<Estudiante> reporteDeTodos();

}
