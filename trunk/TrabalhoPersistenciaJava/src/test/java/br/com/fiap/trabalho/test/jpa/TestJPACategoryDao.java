package br.com.fiap.trabalho.test.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.CategoryDAO;
import br.com.fiap.trabalho.dao.jpa.JPADAOFactory;
import br.com.fiap.trabalho.entity.Category;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "TestJPACategoryDao")
@BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 0)
public class TestJPACategoryDao  extends AbstractBenchmark{
	private static CategoryDAO categoryDAO;

	@Before
	public void init() {
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		categoryDAO = abstractDAOFactory.createCategoryDAO();
		Category category1 = new Category();
		category1.setName("Terror");
		categoryDAO.createCategory(category1);

		Category category2 = new Category();
		category2.setName("Category delete");
		categoryDAO.createCategory(category2);
	}

	@Test
	public void validarcreateDao() {
		Assert.assertNotNull(this.categoryDAO);
	}

	@Test
	public void deleteCategory() {
		List<Category> categoryList = categoryDAO
				.selectCategoryByName("Category delete");
		int idCategory = categoryList.get(0).getId();
		categoryDAO.deleteCategory(categoryList.get(0));
		List<Category> categoryList2 = categoryDAO
				.selectCategoryByName("Category delete");
		if (!categoryList2.isEmpty()) {
			assertTrue(idCategory != categoryList2.get(0).getId());
		} else {
			assertTrue(true);
		}
	}
	
	
	@Test
	public void insertCategory(){
		Category category = new Category();
		category.setName("Category Insert");
		Category c = categoryDAO.createCategory(category);
		assertNotNull(c);
	}
	
	@Test
	public void selectByCategoryName(){
		List<Category> categoryList = categoryDAO
				.selectCategoryByName("Category delete");
		assertNotNull(categoryList);
	}
}
