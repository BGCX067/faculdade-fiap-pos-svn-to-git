package br.com.estudo.designpatterns.hookmethod;

public class ServiceImpl  extends Service{
	

	@Override
	public void process() {
		System.out.println("Executando Process em subclass");
		
	}

}
