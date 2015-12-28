package br.com.fiap.exemplo.ws.client;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWeb hello =  new HelloWebService().getHelloWebPort();
		System.out.println(hello.hello("Barbero"));
	}

}
