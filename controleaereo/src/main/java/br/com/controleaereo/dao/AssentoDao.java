package br.com.controleaereo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.controleaereo.bean.Assento;

@Repository
@SuppressWarnings("unchecked")
public class AssentoDao extends SessionFac implements GenericDAO<Assento> {

	private static AssentoDao INSTANCE;

	private AssentoDao() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}

	public static AssentoDao getInstance() {
		return INSTANCE;
	}

	@Override
	public List<Assento> listAll() {
		List<Assento> assentos = (List<Assento>) getSession().createQuery(
				"from Assento").list();
		return assentos;
	}

	@Override
	public Assento find(Long id) {
		Assento c = (Assento) getSession().get(Assento.class, id);
		return c;
	}

	@Override
	public Assento update(Assento t) {
		getSession().update(t);
		close();
		return t;
	}
	
	public List<Assento> update(List<Assento> t) throws Exception {
		for (Assento assento : t) {
			getSession().merge(assento);	
		}
		close();
		return t;
	}

	@Override
	public Assento save(Assento t) throws Exception {
		getSession().save(t);
		close();
		return t;
	}
	
	public List<Assento> save(List<Assento> t) throws Exception {
		for (Assento assento : t) {
			getSession().save(assento);
		}
		close();
		return t;
	}

	@Override
	public void delete(Assento t) {
		getSession().delete(t);
		close();
	}
	
	public List<Assento> recuperaAssentosDisponiveis(int idUsuario, Long idVoo) {
		Query query = getSession().createQuery("From Assento where (idUsuario = :id0 or idUsuario = :idU) and idVoo = :idV");
		query.setParameter("id0", 0);
		query.setParameter("idU", idUsuario);
		query.setParameter("idV", idVoo);
		List<Assento> list = query.list();
		return list; 	
	}
	
	public List<Assento> recuperaAssentoSelecionados(int idUsuario, Long idVoo) {
		Query query = getSession().createQuery("From Assento where idUsuario = :idU and idVoo = :idV");
		query.setParameter("idU", idUsuario);
		query.setParameter("idV", idVoo);
		List<Assento> list = query.list();
		return list; 	
	}
	
	public void close() {
		SessionFactory sessionFactory = getSession().getSessionFactory();
		getSession().flush();
		getSession().close();
		this.setSession(sessionFactory.openSession());
	}
}
