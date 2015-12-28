package br.com.fiap.ws;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraClient {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:9876/calculadora?wsdl");
			long x =4 , y=2;
			Endpoint.publish("http://127.0.0.1:9876/calculadora",
					new CalculadoraServerImpl());
			QName qname = new QName("http://ws.fiap.com.br/", "CalculadoraServerImplService");
			Service service = Service.create(url, qname);
			CalculadoraServer cs = service.getPort(CalculadoraServer.class);
			System.out.println(x+" + "+y+" = " + cs.soma(x, y));
			System.out.println(x+" - "+y+" = " + cs.subtrai(x, y));
			System.out.println(x+" * "+y+" = " + cs.multiplica(x, y));
			System.out.println(x+" / "+y+" = " + cs.divide(x, y));

	}

}
