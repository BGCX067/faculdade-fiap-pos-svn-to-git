package br.com.fiap;

import java.rmi.RemoteException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RegistraCarrinhoJBoss {

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws NamingException, RemoteException {
		InitialContext context = new InitialContext();
		context.rebind("carrinho", new CarrinhoBean());
		System.out.println("Carrinho registrado no JBoss");
	}

}
