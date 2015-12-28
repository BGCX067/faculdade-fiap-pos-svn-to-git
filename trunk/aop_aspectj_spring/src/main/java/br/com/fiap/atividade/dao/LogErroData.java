package br.com.fiap.atividade.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogErroData {
	
	public void inserirTabelaDeLog(String descricao) throws ClassNotFoundException, SQLException{
		Conexao con = new Conexao();
		PreparedStatement pstmt = con.getConnection().prepareStatement("insert into log_erro(descricao) values (?)");
		pstmt.setString(1, descricao);
		pstmt.executeUpdate();
	}

}
