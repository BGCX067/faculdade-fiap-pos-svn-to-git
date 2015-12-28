package br.com.fiap.cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.com.fiap.rmi.Carrinho;
import br.com.fiap.rmi.Item;



public class ClienteCarrinho {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		Carrinho carrinho = (Carrinho) Naming.lookup("rmi://localhost:1099/farmacia/carrinho");

		Item item1 = new Item();
		item1.setNome("Carlos"); //digite o nome de um item qualquer aqui
		item1.setPreco(3.0);

		Item item2 = new Item();
		item2.setNome("Barbero"); //digite o nome de um item qualquer aqui
		item2.setPreco(5.0);

		carrinho.cadastrarItem(item1);
		carrinho.cadastrarItem(item2);

		System.out.println(carrinho.obterQuantidadeItens());


	}

}
