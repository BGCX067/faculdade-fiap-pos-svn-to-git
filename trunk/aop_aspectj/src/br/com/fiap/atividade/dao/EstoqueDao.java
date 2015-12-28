package br.com.fiap.atividade.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.com.fiap.atividade.bean.Cliente;
import br.com.fiap.atividade.bean.Pedido;
import br.com.fiap.atividade.bean.Produto;

/***
 * 
 * @author Carlos Barbero - carlosrgomes@gmail.com
 * Data: Jul 9, 2013 - 7:51:04 PM
 *
 */
public interface EstoqueDao {
	
	/***
	 * Metodo que retorna a lista de produtos.
	 * @return {@link Produto}
	 */
	public List<Produto> getProdutos();
	
	/***
	 * Metodo responsavel por salvar as compras do cliente.
	 * @param cliente {@link Cliente}
	 * @param dataSistema 
	 * @return {@link Pedido}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Pedido> salvarCompras(Cliente cliente, Date dataSistema) throws ClassNotFoundException, SQLException ;
	
	/***
	 * Metodo responsavel por selecionar o {@link Cliente} por nome;
	 * @param nome {@link String}
	 * @return {@link Cliente}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Cliente selecionarClientePorNome(String nome) throws ClassNotFoundException, SQLException;
	
	/***
	 * Metodo responsavel por selecionar o {@link Produto} pelo nome.
	 * @param nome {@link String}
	 * @return {@link Produto}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Produto selecionarProdutoPorNome(String nome) throws ClassNotFoundException, SQLException;
	
	/***
	 * Metodo responsavel Dao que grava a soma dos produtos.
	 * @param idProduto {@link Long}
	 * @param idCliente {@link Long}
	 * @param data {@link Date}
	 * @return {@link Pedido}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Pedido> somarPedido(Long idProduto, Long idCliente, Date data) throws ClassNotFoundException, SQLException;

}
