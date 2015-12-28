package br.com.fiap.client;

import java.rmi.RemoteException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.Carrinho;
import br.com.fiap.Item;

public class ClienteCarrinhoJBoss {

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws NamingException, RemoteException {
		InitialContext context = new InitialContext();
		Carrinho carrinho = (Carrinho) context.lookup("carrinho");
		//System.out.println(carrinho.getClass());
		//System.out.println(carrinho.toString());

		Item item1 = new Item();
		item1.setNome("Doril");
		item1.setPreco(3.0);

		Item item2 = new Item();
		item2.setNome("Dorflex CA");
		item2.setPreco(5.0);

		carrinho.cadastrarItem(item1);
		carrinho.cadastrarItem(item2);

		System.out.println(carrinho.obterQuantidadeItens());


	}

}
