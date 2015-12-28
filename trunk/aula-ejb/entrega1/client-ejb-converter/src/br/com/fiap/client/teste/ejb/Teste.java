package br.com.fiap.client.teste.ejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.converter.ConverterRemote;

public class Teste {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		Properties properties = new Properties();
		properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.provider.url", "jnp://127.0.0.1:1099");
		
		Context context = new InitialContext(properties);
		Object homeReferece = context.lookup("ConverterBean/remote");
		ConverterRemote converter = (ConverterRemote) javax.rmi.PortableRemoteObject.narrow(homeReferece, ConverterRemote.class);
		
		
		double celsisusToFahrenheit = converter.celsisusToFahrenheit(10f);
		System.out.println("EJB Remoto - celsisusToFahrenheit: "+celsisusToFahrenheit);
		
		double fahrenheitToCelsisus = converter.fahrenheitToCelsisus((float) celsisusToFahrenheit);
		
		System.out.println("EJB Remoto - fahrenheitToCelsisus: "+fahrenheitToCelsisus);
		

	}

}
