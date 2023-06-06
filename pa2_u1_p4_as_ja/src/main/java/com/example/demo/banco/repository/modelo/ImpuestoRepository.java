package com.example.demo.banco.repository.modelo;

import java.math.BigDecimal;

public interface ImpuestoRepository {
	public BigDecimal seleccionar(String codigoImpuesto);
}
