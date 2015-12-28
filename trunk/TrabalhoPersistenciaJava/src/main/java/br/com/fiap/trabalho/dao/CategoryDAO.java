package br.com.fiap.trabalho.dao;

import java.util.List;

import br.com.fiap.trabalho.entity.Category;

/***
 * Interface responsal por definir os metodos do {@link CategoryDAO}
 * @author carlosrgomes@gmail.com
 *
 */
public interface CategoryDAO {
	public Category createCategory(Category category);
	public boolean deleteCategory(Category category);
	public List<Category> selectCategoryByName(String name);
}
