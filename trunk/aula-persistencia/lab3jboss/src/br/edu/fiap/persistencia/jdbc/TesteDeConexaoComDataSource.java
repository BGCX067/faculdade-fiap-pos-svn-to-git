package br.edu.fiap.persistencia.jdbc;

import java.sql.Connection;

public class TesteDeConexaoComDataSource {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		EstatisticaDBManager estatisticaDBManager =  new EstatisticaDBManager();
		Connection connection = estatisticaDBManager.obterConexaoMySQLDataSource();
		System.out.println(connection);
	}

}
