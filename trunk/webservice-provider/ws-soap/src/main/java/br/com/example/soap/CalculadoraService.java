package br.com.example.soap;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import br.com.example.service.calculadora.Calculadora;
import br.com.example.service.calculadora.CalculadoraImpl;

@Stateless
@WebService(serviceName="CalculadoraService")
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class CalculadoraService implements Calculadora {

	@Autowired
	private CalculadoraImpl calculadora;

	@WebMethod
	public int somar(int value1, int value2) {
		return calculadora.somar(value1, value2);
	}
	
	
}
