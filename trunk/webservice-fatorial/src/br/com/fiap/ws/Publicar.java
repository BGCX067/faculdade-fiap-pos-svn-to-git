package br.com.fiap.ws;

import javax.xml.ws.Endpoint;

public class Publicar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OperacaoesImpl operacaoesImpl = new OperacaoesImpl();
		Endpoint endpoint =  Endpoint.publish("http://localhost:8080/operacoes", operacaoesImpl);
		System.out.println("Publicado");
	}

}
