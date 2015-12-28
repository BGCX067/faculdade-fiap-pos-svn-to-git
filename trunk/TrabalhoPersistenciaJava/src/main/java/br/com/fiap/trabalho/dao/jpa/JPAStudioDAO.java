package br.com.fiap.trabalho.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.trabalho.dao.StudioDAO;
import br.com.fiap.trabalho.entity.Studio;

@SuppressWarnings("unchecked")
public class JPAStudioDAO extends JPAConnection implements StudioDAO {


	public Studio createStudio(Studio session) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(session);
		getEntityManager().getTransaction().commit();
		return session;
	}


	public List<Studio> selectStudioByName(String sessionName) {
		Query query = getEntityManager().createQuery("SELECT S FROM Studio S where name = :name", Studio.class);
		query.setParameter("name", sessionName);
		return (List<Studio>) query.getResultList();
	}

}
