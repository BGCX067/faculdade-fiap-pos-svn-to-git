package br.com.fiap.atividade.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String user = "root";
	private String password = "" ;
	private String url = "jdbc:mysql://localhost:3306/fiap";
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
		
	}
	
	public void closeConnection(Connection con) throws SQLException{
		con.close();
	}

}
