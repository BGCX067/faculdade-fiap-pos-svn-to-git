package br.com.carlos;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface Mensagem extends EJBObject {
	
	public String getMensagem() throws RemoteException;

}
