package br.com.controleaereo.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("static-access")
public class SessionFac{
	
	private static Session session;
	
	@Inject
	protected static SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		if (session == null) {
			session = this.sessionFactory.openSession();
		}
		return session;
	}
	
	public void setSession(Session s){
		this.session = s;
	}
}
