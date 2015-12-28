package br.com.estudo.designpatterns.templatemethod;

public abstract class Viagem {
	
	public final void executa(){
		System.out.println("executa");
		embarcar();
		cobrar();
	}
	
	public abstract void embarcar();
	
	public abstract void cobrar();

}
