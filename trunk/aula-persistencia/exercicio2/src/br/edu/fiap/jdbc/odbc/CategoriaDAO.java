package br.edu.fiap.jdbc.odbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements Dao<Categoria> {

	@Override
	public Categoria insert(Categoria t) {
		BibliotecaDBManager bibliotecaDBManager = new BibliotecaDBManager();
		Connection con = null;
		con = bibliotecaDBManager.obterConexaoMySQL();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("insert into tb_categoria(idCategoria, descricao) values(?,? )");
			pstmt.setInt(1, t.getId());
			pstmt.setString(2, t.getDescricao());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}

	@Override
	public void delete(Integer id) {
		BibliotecaDBManager bibliotecaDBManager = new BibliotecaDBManager();
		Connection con = null;
		con = bibliotecaDBManager.obterConexaoMySQL();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("delete from tb_categoria where idCategoria = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Categoria> list() {
		BibliotecaDBManager bibliotecaDBManager = new BibliotecaDBManager();
		ArrayList<Categoria> listaCategoria = null;
		Connection con = null;
		con = bibliotecaDBManager.obterConexaoMySQL();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("select * from tb_categoria");
			
			ResultSet rs = pstmt.executeQuery();
			listaCategoria = new ArrayList<Categoria>();
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setDescricao(rs.getString("descricao"));
				categoria.setId(rs.getInt("idCategoria"));
				listaCategoria.add(categoria);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCategoria;

	}

	@Override
	public Categoria update(Categoria t) {
		BibliotecaDBManager bibliotecaDBManager = new BibliotecaDBManager();
		Connection con = null;
		con = bibliotecaDBManager.obterConexaoMySQL();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("update tb_categoria set descricao = ? where idCategoria = ? ");
			pstmt.setString(1, t.getDescricao());
			pstmt.setInt(2, t.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
