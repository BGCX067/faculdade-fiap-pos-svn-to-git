package br.com.fiap.converter;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@Local(ConverterLocal.class)
@Remote(ConverterRemote.class)
@WebService
public class ConverterBean implements Converter {

	@Override
	public double celsisusToFahrenheit(float celsis) {
		System.out.println("Convertendo celsisusToFahrenheit:" + celsis);
		double f = (celsis * 9 /5 ) + 32;
		return f;
	}

	@Override
	public double fahrenheitToCelsisus(float fahrenheit) {
		System.out.println("Convertendo fahrenheitToCelsisus:" + fahrenheit);
		double celsisus = (fahrenheit - 32) * 5/9;
		return celsisus;
	}

	
	
}
