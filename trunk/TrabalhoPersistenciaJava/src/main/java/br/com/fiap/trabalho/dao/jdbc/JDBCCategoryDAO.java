package br.com.fiap.trabalho.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.trabalho.dao.CategoryDAO;
import br.com.fiap.trabalho.entity.Category;

public class JDBCCategoryDAO extends JDBCConnection implements CategoryDAO {

	public Category createCategory(Category category) {
		try {
			String sql = "INSERT INTO CATEGORY (NAME) VALUES (?)";
			PreparedStatement stm = getConnection().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1, category.getName());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			category.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
			category = null;
		}
		return category;
	}

	public boolean deleteCategory(Category category) {
		try {
			String sql = "DELETE FROM CATEGORY WHERE ID=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setInt(1, category.getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Category> selectCategoryByName(String name) {
		List<Category> categories = null;
		try {
			String sql = "SELECT * FROM CATEGORY WHERE NAME=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setString(1, name);
			ResultSet rs = stm.executeQuery();
			categories = getCategories(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return categories;
		}
		return categories;
	}

	private List<Category> getCategories(ResultSet rs) throws SQLException {
		List<Category> categories = new ArrayList<Category>();
		while (rs.next()) {
			Category category = new Category();
			category.setId(rs.getInt("ID"));
			category.setName(rs.getString("name"));
			categories.add(category);
		}
		return categories;
	}

}