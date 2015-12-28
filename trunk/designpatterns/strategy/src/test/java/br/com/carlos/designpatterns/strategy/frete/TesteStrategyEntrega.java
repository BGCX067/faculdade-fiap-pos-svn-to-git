package br.com.carlos.designpatterns.strategy.frete;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.carlos.designpatterns.strategy.frete.CalculoFreteRjImpl;
import br.com.carlos.designpatterns.strategy.frete.CalculoFreteSpImpl;
import br.com.carlos.designpatterns.strategy.frete.Entrega;


public class TesteStrategyEntrega {
	
	Entrega entrega =  null;
	
	@Before
	public void init(){
		entrega = new Entrega();
	}
	
	
	@Test
	public void testeStrategyCaculoFreteSp(){
		CalculoFreteSpImpl calculoFreteSpImpl =  new CalculoFreteSpImpl();
		entrega.setCalculoFrete(calculoFreteSpImpl);
		double valorCalculado = entrega.getCalculoFrete().calcular(10);
		Assert.assertEquals("Validado Calculo", 20d, valorCalculado, 0d);
	}
	
	@Test
	public void testeStrategyCalculoFreteRj(){
		CalculoFreteRjImpl calculoFreteRjImpl = new CalculoFreteRjImpl();
		entrega.setCalculoFrete(calculoFreteRjImpl);
		double valorCalculado = entrega.getCalculoFrete().calcular(10);
		Assert.assertEquals("Validado Calculo", 30d, valorCalculado, 0d);

	}
	

}
