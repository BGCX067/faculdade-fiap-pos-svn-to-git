package br.com.fiap.javaweb.provaonline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.fiap.javaweb.provaonline.bean.Pessoa;

public class PessoaDaoImpl implements GenericDAO<Pessoa> {
	
	private Session  session;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}

	@Override
	public List<Pessoa> listAll() {
		@SuppressWarnings("unchecked")
		List<Pessoa> list = session.createQuery("from Pessoa").list();
		return list;
	}

	@Override
	public Pessoa find(Long id) {
		return (Pessoa) session.get(Pessoa.class, id);
	}

	@Override
	public Pessoa update(Pessoa t) {
		session.saveOrUpdate(t);
		return t;
	}

	@Override
	public Pessoa save(Pessoa t) {
		session.saveOrUpdate(t);
		return t;
	}

	@Override
	public void delete(Pessoa t) {
		session.delete(t);
	}
	
	
	

}
