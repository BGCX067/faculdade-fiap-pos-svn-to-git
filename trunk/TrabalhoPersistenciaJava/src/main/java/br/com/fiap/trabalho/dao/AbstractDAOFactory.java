package br.com.fiap.trabalho.dao;

/***
 * Classe abstrata de fabrica de DAOs
 * @author carlosrgomes@gmail.com
 *
 */
public abstract class AbstractDAOFactory {
	
	/***
	 * Metodo responsavel por criar o objeto {@link ActorDAO}
	 * @return {@link ActorDAO}
	 */
	public abstract ActorDAO createActorDAO();
	
	/***
	 * Metodo responsavel por criar o objeto {@link MovieDAO}
	 * @return
	 */
	public abstract MovieDAO createMovieDAO();
	
	/***
	 * Metodo responsavel por criar o objeto de {@link CategoryDAO}
	 * @return
	 */
	public abstract CategoryDAO createCategoryDAO();
	
	/***
	 * Metodo responsavel por criar o objeto de {@link StudioDAO}
	 * @return
	 */
	public abstract StudioDAO createStudioDAO();
	
}
