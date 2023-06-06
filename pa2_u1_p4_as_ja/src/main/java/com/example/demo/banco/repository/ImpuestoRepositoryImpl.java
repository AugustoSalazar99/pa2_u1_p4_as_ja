package com.example.demo.banco.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.ImpuestoRepository;
@Repository
public class ImpuestoRepositoryImpl implements ImpuestoRepository{

	@Override
	public BigDecimal seleccionar(String codigoImpuesto) {
		// TODO Auto-generated method stub
		return new BigDecimal(12);
	}

}
