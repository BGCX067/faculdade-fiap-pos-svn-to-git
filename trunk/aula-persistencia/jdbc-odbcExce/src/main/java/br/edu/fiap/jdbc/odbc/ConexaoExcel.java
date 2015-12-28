package br.edu.fiap.jdbc.odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoExcel {
	private Connection connection;

	/***
	 * Metodo responsavel por conectar ao Excel
	 * @return {@link Connection}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		String caminho = "C:/eclipse42/jdbc-odbcExce/src/main/resources/planilha_votacao.xls";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		connection = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};"  + "DBQ=" + caminho );
		return connection;
	}
	
	public void closeConnection() throws SQLException{
		this.connection.close();
	}

}
