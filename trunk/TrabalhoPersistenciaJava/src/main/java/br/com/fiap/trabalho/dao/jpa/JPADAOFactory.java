package br.com.fiap.trabalho.dao.jpa;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.ActorDAO;
import br.com.fiap.trabalho.dao.CategoryDAO;
import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.dao.StudioDAO;

/***
 * Classe  Factory para criacao dos objetos do JPA
 * @author carlosrgomes@gmail.com
 *
 */
public class JPADAOFactory extends AbstractDAOFactory {

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.trabalho.dao.AbstractDAOFactory#createActorDAO()
	 */
	@Override
	public ActorDAO createActorDAO() {
		return new JPAActorDAO();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.trabalho.dao.AbstractDAOFactory#createMovieDAO()
	 */
	@Override
	public MovieDAO createMovieDAO() {
		return new JPAMovieDao();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.trabalho.dao.AbstractDAOFactory#createCategoryDAO()
	 */
	@Override
	public CategoryDAO createCategoryDAO() {
		return new JPACategoryDAO();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.trabalho.dao.AbstractDAOFactory#createStudioDAO()
	 */
	@Override
	public StudioDAO createStudioDAO() {
		return new JPAStudioDAO();
	}
}
