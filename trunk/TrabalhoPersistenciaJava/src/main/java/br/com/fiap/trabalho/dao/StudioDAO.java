package br.com.fiap.trabalho.dao;

import java.util.List;

import br.com.fiap.trabalho.entity.Studio;

/***
 * Interface responsal por definir os metodos do {@link StudioDAO}
 * 
 * @author carlosrgomes@gmail.com
 * 
 */
public interface StudioDAO {
	public Studio createStudio(Studio studio);

	public List<Studio> selectStudioByName(String name);
}
