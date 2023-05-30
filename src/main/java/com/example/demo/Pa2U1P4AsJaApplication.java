package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TranferenciaService;

@SpringBootApplication
public class Pa2U1P4AsJaApplication implements CommandLineRunner {

	@Autowired
	private CuentaService cuentaService;
	@Autowired
	private TranferenciaService tranferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AsJaApplication.class, args);

	}

	@Override

	public void run(String... args) throws Exception {
	
		//Cta 1
		Cuenta cta1 = new Cuenta();
		cta1.setCedulaPropietario("1234");
		cta1.setFechaApertura(LocalDate.now());
		cta1.setNumero("5678");
		cta1.setSaldo(new BigDecimal(200));
		cta1.setTipo("A");
		this.cuentaService.guardar(cta1);
	
		//Cta 2
		Cuenta cta2 = new Cuenta();
		cta1.setCedulaPropietario("0987");
		cta1.setFechaApertura(LocalDate.now());
		cta1.setNumero("7890");
		cta1.setSaldo(new BigDecimal(100));
		cta1.setTipo("A");
		this.cuentaService.guardar(cta2);
		
		
		this.tranferenciaService.realizar("5678", "7890", new BigDecimal(10));
		
		System.out.println("Saldo Origen:"+this.cuentaService.buscarPorNumero("5678").getSaldo());
		System.out.println("Saldo Destino:"+this.cuentaService.buscarPorNumero("7890").getSaldo());
		
	
	}

}
