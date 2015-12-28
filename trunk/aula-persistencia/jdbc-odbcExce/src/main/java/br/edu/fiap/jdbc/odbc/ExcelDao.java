package br.edu.fiap.jdbc.odbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcelDao {

	private Statement statement = null;
	private ResultSet resultSet = null;

	public void executeQuery(Connection connection, String sql)	throws SQLException {
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			System.out.print("\nCategoria: " + resultSet.getString("nome_categoria"));
			System.out.println(" [" + resultSet.getLong(2) + "] votos.");
		}
	}

}
