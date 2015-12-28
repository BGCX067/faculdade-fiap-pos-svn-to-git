package br.com.fiap.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RegistraCarrinho {
	
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1099);
		Naming.rebind("farmacia/carrinho", new CarrinhoBean());
		System.out.println("carrinho registrado");        

	}

}
