package br.com.carlos.ws;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService
public class Calculadora {

	@WebMethod
	public int somar(int value1, int value2){
		return value1 + value2;
	}
	
}
