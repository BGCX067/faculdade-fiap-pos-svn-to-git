package br.com.fiap.atividade.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.fiap.aop.aspectj.FactoryBeanSpring;
import br.com.fiap.atividade.bean.Cliente;
import br.com.fiap.atividade.bean.Pedido;
import br.com.fiap.atividade.bean.Produto;

/***
 * Dao de implementacao do estoque.
 * @author Carlos Barbero - carlosrgomes@gmail.com
 *
 */
public class EstoqueDaoImpl implements EstoqueDao {

	Logger logger = Logger.getLogger(EstoqueDaoImpl.class);

	private Connection con;

	
	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.atividade.dao.EstoqueDao#getProdutos()
	 */
	public List<Produto> getProdutos() {
		List<Produto> lisProdutos = new ArrayList<Produto>();
		try {
			con =  ((Conexao) FactoryBeanSpring.getBean("conexao")).getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("select * from produto");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDscProduto(rs.getString("descricao"));
				produto.setVlrUnitario(rs.getBigDecimal("valorUnitario"));
				produto.setQtd(rs.getLong("quantidade"));
				produto.setDesconto(rs.getDouble("desconto"));
				produto.setTotal(rs.getBigDecimal("total"));
				lisProdutos.add(produto);

			}

		} catch (ClassNotFoundException e) {
			logger.error("Error: ", e);
		} catch (SQLException e) {
			logger.error("Error: ", e);
		}

		return lisProdutos;
	}
	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.atividade.dao.EstoqueDao#salvarCompras(br.com.fiap.atividade.bean.Cliente)
	 */
	public List<Pedido> salvarCompras(Cliente cliente, java.util.Date date) throws ClassNotFoundException,
			SQLException {

		Cliente clienteDataBase = selecionarClientePorNome(cliente.getNome());
		if (clienteDataBase != null) {
			cliente.setId(clienteDataBase.getId());
		}
		Produto produtorDataBase = selecionarProdutoPorNome(cliente.getProduto().getDscProduto());
		
		if (produtorDataBase != null) {
			cliente.getProduto().setId(produtorDataBase.getId());
		}
		Long idPedido = 0l;

		for (int i = 1; i <= cliente.getProduto().getQtd(); i++) {
			con =  ((Conexao) FactoryBeanSpring.getBean("conexao")).getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into pedido(data_compra, cliente_id, produto_id) values (?, ?, ?)");
			PreparedStatement pstmt = con.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, new Date(date.getTime()));
			pstmt.setLong(2, cliente.getId());
			pstmt.setLong(3, cliente.getProduto().getId());
			pstmt.executeUpdate();
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if(generatedKeys.next()){
				idPedido = generatedKeys.getLong(1);
			}
			
			
			new Conexao().closeConnection(con);
		}

		List<Pedido> pedido = somarPedido(cliente.getProduto().getId(), cliente.getId(), date);
		
		for (Pedido pedido2 : pedido) {
			pedido2.setIdCompra(idPedido);
		}
		
		return pedido;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.atividade.dao.EstoqueDao#selecionarClientePorNome(java.lang.String)
	 */
	public Cliente selecionarClientePorNome(String nome)
			throws ClassNotFoundException, SQLException {
		con =  ((Conexao) FactoryBeanSpring.getBean("conexao")).getConnection();
		PreparedStatement pstmt = con
				.prepareStatement("select * from cliente c where c.nome like '%"
						+ nome + "%'");
		ResultSet rs = pstmt.executeQuery();
		Cliente cliente = null;
		while (rs.next()) {
			cliente = new Cliente();
			cliente.setId(rs.getLong("id"));
			cliente.setNome(rs.getString("nome"));
		}
		return cliente;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.atividade.dao.EstoqueDao#selecionarProdutoPorNome(java.lang.String)
	 */
	public Produto selecionarProdutoPorNome(String nome) throws ClassNotFoundException, SQLException {
		con = ((Conexao) FactoryBeanSpring.getBean("conexao")).getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from produto p where p.descricao like '%" + nome + "%'");
		ResultSet rs = pstmt.executeQuery();
		Produto produto = null;
		while (rs.next()) {
			produto = new Produto();
			produto.setId(rs.getLong("id"));

		}
		return produto;
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.atividade.dao.EstoqueDao#somarPedido(java.lang.Long, java.lang.Long, java.util.Date)
	 */
	public List<Pedido> somarPedido(Long idProduto, Long idCliente,
			java.util.Date data) throws ClassNotFoundException, SQLException {
		con =  ((Conexao) FactoryBeanSpring.getBean("conexao")).getConnection();
		PreparedStatement pstmt = con
				.prepareStatement(
						"select pr.id as id_produto, pr.descricao, pr.valorUnitario, pr.desconto " +
						"from pedido p " +
						"inner join produto pr on pr.id = p.produto_id " +
						"inner join cliente c on c.id = p.cliente_id " +
						"where p.cliente_id = ? " +
						"and p.data_compra = ?");
		pstmt.setLong(1, idCliente);
		pstmt.setDate(2, new Date(data.getTime()));
		
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Pedido> retorno = new ArrayList<>();
		Pedido pedido = null;
		while (rs.next()) {
			pedido = new Pedido();
			pedido.setIdProduto(rs.getLong("id_produto"));
			pedido.setDescricao(rs.getString("descricao"));
			pedido.setValorUnitario(rs.getDouble("valorUnitario"));
			pedido.setDesconto(rs.getDouble("desconto"));
			retorno.add(pedido);
		}
		
		
		
		return retorno;
	}

}
