package br.com.fiap.atividade.util;

public class UtilCalculo {
	
	public static  Double calcular(Double valorOriginal, Double porcentagem){
		double value = (valorOriginal * porcentagem ) / 100;
		return value;
	}

}
