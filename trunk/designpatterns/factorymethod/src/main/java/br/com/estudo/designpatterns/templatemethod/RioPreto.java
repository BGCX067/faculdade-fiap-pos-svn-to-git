package br.com.estudo.designpatterns.templatemethod;

public class RioPreto extends Viagem {

	@Override
	public void embarcar() {
		System.out.println("Embarque rio preto ");
	}

	@Override
	public void cobrar() {
		System.out.println("Cobrando rio preto ");
	}

}
