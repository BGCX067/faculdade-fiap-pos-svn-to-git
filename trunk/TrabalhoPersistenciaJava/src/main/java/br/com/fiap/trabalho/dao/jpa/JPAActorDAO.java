package br.com.fiap.trabalho.dao.jpa;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fiap.trabalho.dao.ActorDAO;
import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;

/***
 * Classe Dao de JPA
 * 
 * @author carlosrgomes@gmail.com
 * 
 */
public class JPAActorDAO extends JPAConnection implements ActorDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.fiap.trabalho.dao.ActorDAO#createActor(br.com.fiap.trabalho.entity
	 * .Actor)
	 */
	public Actor createActor(Actor actor) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(actor);
		getEntityManager().getTransaction().commit();
		return actor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.fiap.trabalho.dao.ActorDAO#deleteActor(br.com.fiap.trabalho.entity
	 * .Actor)
	 */
	public boolean deleteActor(Actor actor) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(actor);
		getEntityManager().getTransaction().commit();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.fiap.trabalho.dao.ActorDAO#selectActorByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<Actor> selectActorByName(String name) {
		TypedQuery<Actor> query = getEntityManager().createQuery(
				"SELECT A FROM Actor A WHERE fullName = :name", Actor.class);
		query.setParameter("name", name);
		return (List<Actor>) query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.fiap.trabalho.dao.ActorDAO#selectActorByAge(int)
	 */
	public List<Actor> selectActorByAge(int age) {
		TypedQuery<Actor> query = getEntityManager().createQuery(
				"SELECT A FROM Actor A WHERE YEAR(birthDate) = :year",
				Actor.class);
		query.setParameter("year", getYear(age));

		return (List<Actor>) query.getResultList();
	}

	private int getYear(int age) {
		Calendar c = new GregorianCalendar();
		int ano = c.get(Calendar.YEAR);
		return ano - age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.fiap.trabalho.dao.ActorDAO#selectActorByMovie(br.com.fiap.trabalho
	 * .entity.Movie)
	 */
	public Set<Actor> selectActorByMovie(Movie movie) {
		String sql = "SELECT m.actors FROM Movie m WHERE m.id = :id ";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("id", movie.getId());
		return new HashSet(query.getResultList());
	}

}
