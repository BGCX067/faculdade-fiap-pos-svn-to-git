package br.com.example.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.service.calculadora.Calculadora;

@RestController
@RequestMapping("caluladora")
public class CalculadoraResource implements Calculadora{
	
	@Autowired
	private Calculadora calculadora;

	
	@RequestMapping(value="/somar/{valor1}/{valor2}", method=RequestMethod.GET,produces={"application/xml", "application/json"})
	@ResponseStatus(HttpStatus.OK)
	public int somar(@PathVariable("valor1") int value1, @PathVariable("valor2") int value2) {
		return calculadora.somar(value1, value2);
	}
	

}
