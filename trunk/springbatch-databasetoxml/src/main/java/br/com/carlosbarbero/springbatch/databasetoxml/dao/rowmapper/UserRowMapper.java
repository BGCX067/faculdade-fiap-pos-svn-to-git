package br.com.carlosbarbero.springbatch.databasetoxml.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.carlosbarbero.springbatch.databasetoxml.bean.User;

public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setIdade(rs.getInt("IDADE"));
		user.setLogin(rs.getString("LOGIN"));
		user.setPassword(rs.getString("PASSWORD"));
		return user;
	}

}
