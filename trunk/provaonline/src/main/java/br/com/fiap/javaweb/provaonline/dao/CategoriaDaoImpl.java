package br.com.fiap.javaweb.provaonline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.fiap.javaweb.provaonline.bean.Categoria;

public class CategoriaDaoImpl implements GenericDAO<Categoria> {
	private Session session;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}

	@Override
	public List<Categoria> listAll() {
		@SuppressWarnings("unchecked")
		List<Categoria> list = session.createQuery("from Categoria").list();
		close();
		return list;
	}

	@Override
	public Categoria find(Long id) {
		Categoria c = (Categoria) session.get(Categoria.class, id);
		close();
		return c;
	}

	@Override
	public Categoria update(Categoria t) {
		session.merge(t);
		close();
		return t;
	}

	@Override
	public Categoria save(Categoria t) {
		session.saveOrUpdate(t);
		close();
		return t;
	}

	@Override
	public void delete(Categoria t) {
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
