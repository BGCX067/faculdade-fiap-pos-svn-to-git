package br.com.fiap.trabalho.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCLoginDAO extends JDBCConnection {

	public boolean login(String login, String senha) {
		try {
			String sql = "SELECT LOGIN FROM LOGIN WHERE LOGIN='" + login + "' AND SENHA='" + senha + "'";
			System.out.println(sql);
			PreparedStatement stm = getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			rs.next();
			String a = rs.getString("LOGIN");
			if(a != null){
				return true;
			}
		} catch (SQLException e) {
		}
		return false;
	}

	public void createLogin() {
		try {
			String sql = "INSERT INTO LOGIN (LOGIN, SENHA) VALUES ('ADM','123')";
			PreparedStatement stm = getConnection().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
		} catch (SQLException e) {
			System.out.println("*****************************************************************************\n***************************************************************");
		}
	}
}
