package br.edu.fiap.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class EstatisticaDBManager {

	public Connection obterConexaoMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/estatistica", "root", "fiap");
	}

}
