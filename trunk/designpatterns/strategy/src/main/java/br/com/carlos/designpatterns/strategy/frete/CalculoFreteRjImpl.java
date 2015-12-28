package br.com.carlos.designpatterns.strategy.frete;

public class CalculoFreteRjImpl implements CalculoFrete {

	@Override
	public double calcular(double valor) {
		return valor * 3;
	}

}
