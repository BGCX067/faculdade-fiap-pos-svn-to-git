package br.com.fiap.trabalho.dao;

import java.util.List;
import java.util.Set;

import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;

/***
 * Interface responsal por definir os metodos do {@link ActorDAO}
 * @author carlosrgomes@gmail.com
 *
 */
public interface ActorDAO {
	
	/***
	 * Metodo responsavel pela criacao do {@link Actor}
	 * @param {@link Actor}
	 * @return {@link Actor}
	 */
	public Actor createActor(Actor actor);
	
	/***
	 * Metodo responsavel por deletar o {@link Actor}
	 * @param actor
	 * @return
	 */
	public boolean deleteActor(Actor actor);
	
	/***
	 * Metodo responsavel por selecionar os {@link Actor} por Nome.
	 * @param name {@link String} contendo o nome para buscar no Banco de Dados.
	 * @return {@link List} contendo os {@link Actor}
	 */
	public List<Actor> selectActorByName(String name);
	
	/***
	 * Metodo responsavel por selecionar os {@link Actor} por idade.
	 * @param age contendo a idade do {@link Actor}
	 * @return {@link List} contendo os {@link Actor}
	 */
	public List<Actor> selectActorByAge(int age);
	
	/***
	 * Metodo responsavel por selecionar os {@link Actor} por {@link Movie}
	 * @param movie {@link Movie}
	 * @return {@link List} contendo uma lista De {@link Actor}
	 */
	public Set<Actor> selectActorByMovie(Movie movie);

}
