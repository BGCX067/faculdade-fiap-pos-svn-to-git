package br.com.fiap.trabalho.dao;

import java.util.List;
import java.util.Locale.Category;

import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;

/***
 * Interface responsal por definir os metodos do {@link MovieDAO}
 * @author carlosrgomes@gmail.com
 *
 */
public interface MovieDAO {
	
	/***
	 * Metodo responsavel por criar o {@link Movie}
	 * @param movie {@link Movie}
	 * @return {@link Movie}
	 */
	public Movie createMovie(Movie movie);
	
	/***
	 * Metodo responsavel por deletar {@link Movie}
	 * @param movie {@link Movie}
	 * @return {@link Boolean}
	 */
	public boolean deleteMovie(Movie movie);
	
	/***
	 * Metodo responsavel por selectionar todos os {@link Movie} por Title {@link String}
	 * @param title {@link String}
	 * @return {@link List} de {@link Movie}
	 */
	public List<Movie> selectMoviesByTitle(String title);
	
	/***
	 * Metodo responsavel por selecionar os {@link Movie} por year.
	 * @param year {@link Integer}
	 * @return {@link List} de {@link Movie}
	 */
	public List<Movie> selectMoviesByYear(int year);
	
	/***
	 * Metodo responsavel por selecionar os {@link Movie} por nome do {@link Actor}
	 * @param actorName {@link String}
	 * @return {@link List} de {@link Movie}
	 */
	public List<Movie> selectMoviesByActorName(String actorName);
	
	/***
	 * Metodo responsavel por selecionar os {@link Movie} por nome da {@link Category}
	 * @param categoryName {@link String}
	 * @return {@link List} de {@link Movie}
	 */
	public List<Movie> selectMoviesByCategoryName(String categoryName);
	
	/***
	 * Metodo responsavel por selecionar {@link Movie} por nome do Studio
	 * @param studioName {@link String}
	 * @return {@link List} de {@link Movie}
	 */
	public List<Movie> selectMoviesByStudioName(String studioName);
	
	public Movie find(int id);	

}
