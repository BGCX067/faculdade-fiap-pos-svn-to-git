package br.com.carlos.teste;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import br.com.carlos.Mensagem;
import br.com.carlos.MensagemHome;

public class Cliente {
	
	
	public static void main(String[] args) throws NamingException, RemoteException {
		Properties properties = new Properties();
	    
	    properties.put(Context.INITIAL_CONTEXT_FACTORY, 
	        "org.openejb.client.LocalInitialContextFactory");
	    
	    InitialContext ctx = new InitialContext(properties);
	    
	    Object obj = ctx.lookup("MensagemBeanRemoteHome");
	    
	    Mensagem ejbHome = (Mensagem) PortableRemoteObject.narrow(obj, Mensagem.class);
		System.out.println("#########"+ejbHome.getMensagem());
	}

}
