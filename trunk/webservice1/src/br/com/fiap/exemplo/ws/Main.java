package br.com.fiap.exemplo.ws;

import javax.xml.ws.Endpoint;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWeb service = new HelloWeb();
		Endpoint endpoint =  Endpoint.publish("http://localhost:8080/hello", service);
		

	}

}
