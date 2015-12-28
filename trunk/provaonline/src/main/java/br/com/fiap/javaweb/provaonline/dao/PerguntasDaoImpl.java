package br.com.fiap.javaweb.provaonline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.fiap.javaweb.provaonline.bean.Questoes;


public class PerguntasDaoImpl implements GenericDAO<Questoes> {
	private Session session;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}

	@Override
	public List<Questoes> listAll() {
		@SuppressWarnings("unchecked")
		List<Questoes> list = session.createQuery("from Questoes").list();
		close();
		return list;
	}

	@Override
	public Questoes find(Long id) {
		Questoes c = (Questoes) session.get(Questoes.class, id);
		close();
		return c;
	}

	@Override
	public Questoes update(Questoes t) {
		session.merge(t);
		close();
		return t;
	}

	@Override
	public Questoes save(Questoes t) {
		session.saveOrUpdate(t);
		close();
		return t;
	}

	@Override
	public void delete(Questoes t) {
		session.delete(t);
		close();
	}

	public void close() {
		SessionFactory sessionFactory = session.getSessionFactory();
		session.flush();
		session.close();
		session = sessionFactory.openSession();
	}
}
