package br.com.fiap.exemplo.ws;

import javax.jws.WebService;

@WebService
public class HelloWeb {

	
	public String hello(String nome) {
		return "Hello " + nome;
	}
	
}
