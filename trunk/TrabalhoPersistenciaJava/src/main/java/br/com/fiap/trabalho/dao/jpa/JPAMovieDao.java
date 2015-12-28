package br.com.fiap.trabalho.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.entity.Movie;

public class JPAMovieDao extends JPAConnection implements MovieDAO {

	public Movie createMovie(Movie movie) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(movie);
		getEntityManager().getTransaction().commit();
		return movie;
	}

	public boolean deleteMovie(Movie movie) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(movie);
		getEntityManager().getTransaction().commit();
		return true;
	}
	
	public Movie find(int id){
		Movie movie = getEntityManager().find(Movie.class, id);
		return movie;
	}

	public List<Movie> selectMoviesByTitle(String title) {
		TypedQuery<Movie> query = getEntityManager().createQuery(
				"SELECT M FROM Movie M WHERE title = :title", Movie.class);
		query.setParameter("title", title);
		return (List<Movie>) query.getResultList();
	}

	public List<Movie> selectMoviesByYear(int year) {
		TypedQuery<Movie> query = getEntityManager().createQuery(
				"SELECT m FROM Movie m WHERE yearr = :year", Movie.class);
		query.setParameter("year", year);

		return (List<Movie>) query.getResultList();
	}

	public List<Movie> selectMoviesByActorName(String actorName) {
		TypedQuery<Movie> query = getEntityManager().createQuery(
				"SELECT m FROM Movie m JOIN m.actors a WHERE a.fullName = :fullName", Movie.class);
		query.setParameter("fullName", actorName);
		return (List<Movie>) query.getResultList();	
	}

	public List<Movie> selectMoviesByCategoryName(String categoryName) {
		TypedQuery<Movie> query = getEntityManager().createQuery(
				"SELECT m FROM Movie m JOIN m.categories c WHERE c.name = :name", Movie.class);
		query.setParameter("name", categoryName);
		return (List<Movie>) query.getResultList();	
	}

	public List<Movie> selectMoviesByStudioName(String studioName) {
		TypedQuery<Movie> query = getEntityManager().createQuery(
				"SELECT m FROM Movie m JOIN m.studio s WHERE s.name = :name", Movie.class);
		query.setParameter("name", studioName);
		return (List<Movie>) query.getResultList();
	}

}
