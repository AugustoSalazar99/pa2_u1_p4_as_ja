package com.example.demo.banco.repository.modelo;

import java.math.BigDecimal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("singleton")
public class Impuesto {
	
	private BigDecimal iva;
	

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "Impuesto [iva=" + iva + "]";
	}
	

}
