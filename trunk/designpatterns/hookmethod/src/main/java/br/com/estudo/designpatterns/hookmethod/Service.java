package br.com.estudo.designpatterns.hookmethod;

public abstract class Service {

	public final void execute(){
		System.out.println("Executando Service");
		process();
	}
	
	public abstract void process();
	
}
