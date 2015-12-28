package br.com.barbero.autoatendimento.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.barbero.autoatendimento.bean.Cliente;
import br.com.barbero.autoatendimento.bean.Conta;
import br.com.barbero.autoatendimento.bean.Extrato;
import br.com.barbero.autoatendimento.bean.TipoConta;
import br.com.barbero.autoatendimento.bean.TipoOperacao;
/***
 * Classe de Implementacao de DAO, responsavel por disponibilizar insformacoes referente a manipulacao com banco de dados.
 * @author Alexandre Genka
 *
 */
public class ClienteDaoImpl implements GenericDAO<Cliente> {
	
	private Logger logger = Logger.getLogger(ClienteDaoImpl.class.getName());
	private PreparedStatement preparedStatement = null;

	/*
	 * (non-Javadoc)
	 * @see br.com.barbero.autoatendimento.dao.GenericDAO#consultar(java.lang.Long)
	 */
	@Override
	public Cliente consultar(Long id) {
		Cliente cliente = null;
		Conta conta = null;
		Conexao con = new Conexao();
		Connection cone = null;
		try {
			cone = con.getConnection();
			preparedStatement = cone.prepareStatement("select * from cliente c inner join conta co on" +
					" co.cliente_idcliente = c.idcliente where c.idcliente = ? ");
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("idcliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setDataNascimento(rs.getDate("dataNascimento"));
				cliente.setCpf(rs.getString("cpf"));
			    conta = new Conta();
				conta.setId(rs.getLong("numConta"));
				conta.setSaldoDaConta(rs.getBigDecimal("saldoEmConta"));
				conta.setData(rs.getDate("data"));
				conta.setTipoConta(TipoConta.BUSCAR.getTipoConta(rs.getString("TipoConta")));
				cliente.setConta(conta);
				
			}
			
			if(conta != null){
				preparedStatement = con.getConnection().prepareStatement("select * from historico_conta h where h.conta_numConta = ?");
				preparedStatement.setLong(1, conta.getId());
				ResultSet res = preparedStatement.executeQuery();
				ArrayList<Extrato> lista = new ArrayList<Extrato>();
				while (res.next()) {
					Extrato extrato = new Extrato();
					extrato.setDataOperacao(res.getDate("dataOperacao"));
					extrato.setTipoDaOperacao(res.getString("tipoOperacao").equals("DEPOSITO") ? TipoOperacao.DEPOSITO : TipoOperacao.SAQUE);
					extrato.setValor(res.getBigDecimal("valor"));
					lista.add(extrato);
				}
				
				conta.setOperacoes(lista);
				
			}
			
			
			
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		finally{
			try {
				cone.close();
			} catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
		return cliente;
	}


	@Override
	public synchronized void depositar(Cliente cliente, BigDecimal valorDepositor) {
		Conexao con = new Conexao();
		Connection cone = null;
		try {
			BigDecimal novoValor = cliente.getConta().getSaldoDaConta().add(valorDepositor);
			cone = con.getConnection();
			PreparedStatement pstmt = cone.prepareStatement("update  conta c set c.saldoEmConta = ? where c.numConta = ?");
			pstmt.setDouble(1, novoValor.doubleValue());
			pstmt.setLong(2, cliente.getConta().getId());
			pstmt.executeUpdate();
			pstmt = cone.prepareStatement("insert into historico_conta  (dataOperacao, tipoOperacao, valor, conta_numConta) values (?, ?, ?, ?) ");
			pstmt.setDate(1, new Date(new java.util.Date().getTime()));
			pstmt.setString(2, TipoOperacao.DEPOSITO.toString());
			pstmt.setBigDecimal(3 , valorDepositor);
			pstmt.setLong(4, cliente.getConta().getId());
			pstmt.executeUpdate();
		
		}catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		finally{
			try {
				cone.close();
			} catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
		
	}


	public synchronized void sacar(Cliente cliente, BigDecimal valorSaque) {
		if(cliente.getConta().getSaldoDaConta().compareTo(valorSaque) == 0 || cliente.getConta().getSaldoDaConta().compareTo(valorSaque) == 1){
			Conexao con = new Conexao();
			Connection cone = null;
			try {
				BigDecimal novoValor = cliente.getConta().getSaldoDaConta().subtract(valorSaque);
				cone = con.getConnection();
				PreparedStatement pstmt = cone.prepareStatement("update  conta c set c.saldoEmConta = ? where c.numConta = ?");
				pstmt.setDouble(1, novoValor.doubleValue());
				pstmt.setLong(2, cliente.getConta().getId());
				pstmt.executeUpdate();
				pstmt = cone.prepareStatement("insert into historico_conta  (dataOperacao, tipoOperacao, valor, conta_numConta) values (?, ?, ?, ?) ");
				pstmt.setDate(1, new Date(new java.util.Date().getTime()));
				pstmt.setString(2, TipoOperacao.SAQUE.toString());
				pstmt.setBigDecimal(3 , valorSaque);
				pstmt.setLong(4, cliente.getConta().getId());
				pstmt.executeUpdate();
			}catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
			finally{
				try {
					cone.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, e.getMessage());
				}
			}
		}else{
			logger.log(Level.ALL, "Saldo indisponivel");
			throw new RuntimeException("Saldo indisponível na Conta.");
		}
	}

}
