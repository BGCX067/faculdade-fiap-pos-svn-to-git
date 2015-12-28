package br.com.fiap.teste;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.CarrinhoRemote;
import br.com.fiap.Item;

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
		Object homeReferece = context.lookup("CarrinhoBean/remote");
		CarrinhoRemote home = (CarrinhoRemote) javax.rmi.PortableRemoteObject.narrow(homeReferece, CarrinhoRemote.class);
	
		Item item = new Item();
		item.setNome("Carlos");
		home.cadastrarItem(item);
		

	}

}
