package br.com.carlos;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MensagemBean implements SessionBean {

	private static final long serialVersionUID = 1L;
	private SessionContext context;

	public String getMensagem() {
		return "Meu EJB saiu!";
	}

	public void ejbCreate() throws CreateException {
		System.out.println("Bean criado");
	}

	public void setSessionContext(SessionContext context) {
		this.context = context;
	}

	public void ejbActivate() {
		System.out.println("Bean Ativado");
	}

	public void ejbRemove() {
		System.out.println("Bean Removido");
	}

	public void ejbPassivate() {
		System.out.println("Bean Desativado");
	}

}
