package br.edu.fiap.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstatisticaDAO {

	private Connection conexao;

	private void obterConexao() throws Exception {
		EstatisticaDBManager estatisticaDBManager = new EstatisticaDBManager();
		this.conexao = estatisticaDBManager.obterConexaoMySQL();
	}

	private void fecharConexao() throws Exception {
		this.conexao.close();
	}

	public List<String> obterTodasQuestoes() throws Exception {
		obterConexao();
		List<String> questionarios = new ArrayList<String>();
		Statement stmt = conexao.createStatement();
		String sql = "SELECT idquestao, descricao FROM questao";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			questionarios.add(rs.getString(2));
		}
		stmt.close();
		rs.close();
		fecharConexao();
		return questionarios;
	}

	public void criarQuestao(String descricao, String[] respostas)
			throws Exception {
		obterConexao();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		int codigoQuestao;
		// insercao da questao
		sql = "INSERT INTO questao (descricao) VALUES (?)";
		preparedStatement = conexao.prepareStatement(sql);
		preparedStatement.setString(1, descricao);
		preparedStatement.execute();
		// recuperacao do codigo da questao recem criada
		sql = "SELECT idquestao FROM questao WHERE descricao = ?";
		preparedStatement = conexao.prepareStatement(sql);
		preparedStatement.setString(1, descricao);
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		codigoQuestao = resultSet.getInt("idquestao");
		// insersao das respostas
		sql = "INSERT INTO resposta (idquestao, descricao) VALUES (?, ?)";
		for (int i = 0; i < respostas.length; i++) {
			preparedStatement = conexao.prepareStatement(sql);
			preparedStatement.setInt(1, codigoQuestao);
			preparedStatement.setString(2, respostas[i]);
			preparedStatement.execute();
		}
		preparedStatement.close();
		resultSet.close();
		fecharConexao();
	}

	public void apagarTodasQuestoes() throws Exception {
		obterConexao();
		Statement stmt = conexao.createStatement();
		String sql = "DELETE FROM questao";
		stmt.execute(sql);
		fecharConexao();
	}
	
	
	public List<String> obterRespostas(int idQuestao) throws Exception{
		obterConexao();
		PreparedStatement stmt = conexao.prepareStatement("select r.idresposta, r.descricao from questao q inner join resposta r on q.idquestao = r.idquestao where r.idquestao = ?");
		stmt.setInt(1, idQuestao);
		
		ResultSet rs = stmt.executeQuery();
		ArrayList<String> listaResposta = new ArrayList<>();
		
		while (rs.next()) {
			listaResposta.add(rs.getString("idresposta") +" " + rs.getString("descricao"));
		}
		
		return listaResposta;
	}

}
