package br.com.barbero.autoatendimento.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * Classe responsavel por conectar ao Banco de Dados HSQLDB In Memory
 * @author Carlos Barbero
 *
 */
public class Conexao {
	
	private Logger log = Logger.getLogger(Conexao.class.getName());
	
	/***
	 * Conecta ao Banco de Dados.
	 * @return {@link Connection} retorna a conexao com o Banco de Dados.
	 */
	public Connection getConnection(){
		Connection con = null;
		try {
		      Class.forName("org.h2.Driver" );
		       con = DriverManager.getConnection("jdbc:h2:mem:banco;DB_CLOSE_DELAY=-1", "root", "root");
		  } catch (SQLException e) {
			  log.log(Level.SEVERE, e.getMessage());
		  } catch (ClassNotFoundException e) {
			  log.log(Level.SEVERE, e.getMessage());
		}
		return con;
	}
	
	

}
