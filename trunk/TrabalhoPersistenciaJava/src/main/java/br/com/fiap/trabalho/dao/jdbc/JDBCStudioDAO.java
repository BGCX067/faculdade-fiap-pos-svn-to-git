package br.com.fiap.trabalho.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.trabalho.dao.StudioDAO;
import br.com.fiap.trabalho.entity.Studio;

public class JDBCStudioDAO extends JDBCConnection implements StudioDAO {

	public Studio createStudio(Studio studio) {
		try {
			String sql = "INSERT INTO STUDIO (NAME) VALUES (?)";
			PreparedStatement stm = getConnection().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1, studio.getName());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			studio.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
			studio = null;
		}
		return studio;
	}

	public List<Studio> selectStudioByName(String name) {
		List<Studio> studios = new ArrayList<Studio>();
		try {
			String sql = "SELECT * FROM STUDIO WHERE NAME=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setString(1, name);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Studio studio = new Studio();
				studio.setId(rs.getInt("ID"));
				studio.setName(rs.getString("NAME"));
				studios.add(studio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return studios;
		}
		return studios;
	}
}
