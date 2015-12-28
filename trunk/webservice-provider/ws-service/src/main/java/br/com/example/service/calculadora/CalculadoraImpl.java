package br.com.example.service.calculadora;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraImpl implements Calculadora {

	public int somar(int value1, int value2) {
		return value1 + value2;
	}

}
