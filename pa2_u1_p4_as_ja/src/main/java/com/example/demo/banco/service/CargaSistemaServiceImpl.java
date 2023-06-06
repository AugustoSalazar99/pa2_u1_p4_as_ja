package com.example.demo.banco.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.modelo.Impuesto;
import com.example.demo.banco.repository.modelo.ImpuestoRepository;
@Service
public class CargaSistemaServiceImpl implements CargaSistemaService {

	@Autowired
	private Impuesto impuesto;
	@Autowired
	private ImpuestoRepository impuestoRepository;
	@Override
	public void cargar() {
		// TODO Auto-generated method stub
		System.out.println("Inicia carga de impuestos");
		BigDecimal valorIva=this.impuestoRepository.seleccionar("IVA");
		this.impuesto.setIva(valorIva);
		System.out.println("Finaliza la carga de impuestos");
	}

}
