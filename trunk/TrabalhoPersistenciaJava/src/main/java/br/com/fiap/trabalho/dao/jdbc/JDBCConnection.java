package br.com.fiap.trabalho.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JDBCConnection {
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
			String URL = "jdbc:log4jdbc:derby:simpleDB;create=true";
			String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return conn;
	}
	public static void main(String[] args) {
		new JDBCConnection();
	}
}
