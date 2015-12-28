package br.edu.fiap.jdbc.odbc;

import java.sql.Connection;
import java.sql.SQLException;

/***
 * Classe de Teste para Leitura do Excel.
 * @author Carlos Barbero
 *
 */
public class RelatorioEstatisticaExcel {
	
	private static final String SQL = "SELECT nome_categoria, total_votos FROM [Plan1$]";

	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConexaoExcel  conexaoExcel =  new ConexaoExcel();
		Connection connection = conexaoExcel.getConnection();
		try{
			ExcelDao excelDao = new ExcelDao();
			excelDao.executeQuery(connection, SQL);
		}catch(Exception ex){
			conexaoExcel.closeConnection();
		}
		
	}
}
