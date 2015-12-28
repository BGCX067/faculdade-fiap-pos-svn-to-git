package br.edu.fiap.jdbc.odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BibliotecaDBManager {
	
	private static Connection CONNECTION = null;

	public Connection obterConexaoMySQL()  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			CONNECTION = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "fiap");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return CONNECTION;
	}
}
