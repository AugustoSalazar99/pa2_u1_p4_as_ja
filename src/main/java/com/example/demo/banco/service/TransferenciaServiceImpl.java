package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements TranferenciaService {
	@Autowired
	private CuentaRepository cuentaRepository;
	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@Override
	public void guardar(Transferencia transferencia) {

		this.transferenciaRepository.insertar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {

		this.transferenciaRepository.actualiza(transferencia);
	}

	@Override
	public void borrar(String numero) {

		this.transferenciaRepository.eliminar(numero);
	}

	@Override
	public Transferencia buscarPorNumero(String numero) {

		return this.transferenciaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// 1.- consultar la cuenta de origen por el numero de cta
		Cuenta ctaOrigen = this.cuentaRepository.seleccionarPorNumero(numeroCtaOrigen);
		// 2.- Cosnultar el saldo de la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();

		// 3.- Validar si el saldo es suficiente
		if (monto.compareTo(saldoOrigen) <= 0) {

			// 5.- Si si es suficiente ir al paso 6
			// 6.- Realizamos la resta del saldo origen - monto
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
			// 7.- Actualizamos el nuevo saldo de la cta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepository.actualizar(ctaOrigen);
			// 8.- Consultamos la cta de destino por el numero
			Cuenta ctaDestino = this.cuentaRepository.seleccionarPorNumero(numeroCtaDestino);
			// 9.- Consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			// 10.- Realizamos la suma del saldo destino + monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);

			// 11.- Actualizamos el nuevo saldo de la cta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.cuentaRepository.actualizar(ctaDestino);
			// 12.- Creamos la transferencia
			Transferencia transfer = new Transferencia();
			transfer.setCuentaOrigen(ctaOrigen);
			transfer.setCuentaDestino(ctaDestino);
			transfer.setMonto(monto);
			Double numero = Math.random();
			transfer.setNumero(numero.toString());
			transfer.setFecha(LocalDateTime.now());
			this.transferenciaRepository.insertar(transfer);
			
		
		} else {
			// 4.- Si no es suficiente imprimir mensaje de no hay saldo suficiente
			System.out.println("Saldo no disponible, su saldo es: " + saldoOrigen);

		}

	}

}
