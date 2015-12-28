package br.com.carlos;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MensagemHome extends EJBHome {

	public Mensagem create() throws RemoteException, CreateException;  

}
