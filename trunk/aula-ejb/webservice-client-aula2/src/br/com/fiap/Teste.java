package br.com.fiap;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class Teste {

	/**
	 * @param args
	 * @throws ServiceException 
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws ServiceException, RemoteException {
		CarrinhoBeanServiceLocator carrinhoBeanServiceLocator =  new CarrinhoBeanServiceLocator();
		CarrinhoBean carrinhoBeanPort = carrinhoBeanServiceLocator.getCarrinhoBeanPort();
		Item item = new Item();
		item.setNome("Carlos");
		item.setPreco(10d);
		carrinhoBeanPort.cadastrarItem(item );

	}

}
