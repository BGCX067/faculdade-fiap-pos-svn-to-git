package br.com.estudo.designpatterns.templatemethod;

public class SaoPaulo extends Viagem {

	@Override
	public void embarcar() {
		System.out.println("Embarque SP ");
	}

	@Override
	public void cobrar() {
		System.out.println("Cobrando SP ");
	}

}
