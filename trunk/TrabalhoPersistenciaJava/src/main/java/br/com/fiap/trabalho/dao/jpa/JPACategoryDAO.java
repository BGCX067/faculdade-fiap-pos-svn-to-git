package br.com.fiap.trabalho.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.trabalho.dao.CategoryDAO;
import br.com.fiap.trabalho.entity.Category;

@SuppressWarnings("unchecked")
public class JPACategoryDAO extends JPAConnection implements CategoryDAO {


	public Category createCategory(Category category) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(category);
		getEntityManager().getTransaction().commit();
		return category;
	}


	public boolean deleteCategory(Category category) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(category);
		getEntityManager().getTransaction().commit();
		return true;
	}

	public List<Category> selectCategoryByName(String categoryName) {
		Query query = getEntityManager().createQuery("SELECT C FROM Category C where name = :name", Category.class);
		query.setParameter("name", categoryName);
		return (List<Category>) query.getResultList();
	}

}
