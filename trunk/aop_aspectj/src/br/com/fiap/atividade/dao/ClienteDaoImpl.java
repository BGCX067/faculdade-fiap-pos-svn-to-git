package br.com.fiap.atividade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.fiap.atividade.bean.Cliente;

/***
 * Classe de Implementacao do ClienteDAO.
 * @author Carlos Barbero - carlosrgomes@gmail.com
 * Data: Jul 9, 2013 - 7:51:29 PM
 *
 */
public class ClienteDaoImpl implements ClienteDao {
	
	private Connection con;
	
	Logger logger = Logger.getLogger(ClienteDaoImpl.class);

	@Override
	public List<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			con = new Conexao().getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from cliente");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				clientes.add(cliente);
			}
			

		} catch (ClassNotFoundException e) {
			logger.error("Error: ", e);
		} catch (SQLException e) {
			logger.error("Error: ", e);
		}
		
		return clientes;
	}
	
	
}
