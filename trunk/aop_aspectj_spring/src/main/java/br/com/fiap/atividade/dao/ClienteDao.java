package br.com.fiap.atividade.dao;

import java.util.List;

import br.com.fiap.atividade.bean.Cliente;

/***
 * Iterface que define os metodos dos Daos de cliente.
 * @author Carlos Barbero - carlosrgomes@gmail.com
 * Data: Jul 9, 2013 - 7:51:50 PM
 *
 */
public interface ClienteDao {
	
	/***
	 * Metodo responsavel por retornar os clientes.
	 * @return {@link List} {@link Cliente}
	 */
	List<Cliente> getClientes();

}
