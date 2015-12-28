package br.edu.fiap.jdbc.odbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO  {

	public Livro insert(Livro t, Editora editora)  {
		BibliotecaDBManager bibliotecaDBManager = new BibliotecaDBManager();
		Connection con = null;
		con = bibliotecaDBManager.obterConexaoMySQL();
		
		PreparedStatement pstmt;
		PreparedStatement pstmtEditora;
		try {
			con.setAutoCommit(false);
			
			pstmtEditora = con.prepareStatement("insert into tb_editora (nome) values (?)", Statement.RETURN_GENERATED_KEYS);
			pstmtEditora.setString(1, editora.getNome());
			pstmtEditora.executeUpdate();
			
			ResultSet generatedKeys = pstmtEditora.getGeneratedKeys();
			if(generatedKeys.next()){
				Integer value = generatedKeys.getInt(1);
				t.getEditora().setId(value);
			}
			
			pstmt = con.prepareStatement("insert into tb_livro(ISBN, titulo, autor, idEditora, idCategoria) values(?, ? ,?, ?, ?)");
			pstmt.setInt(1, t.getIsbn());
			pstmt.setString(2, t.getAutor());
			pstmt.setString(3, t.getTitulo());
			pstmt.setInt(4,t.getEditora().getId());
			pstmt.setInt(5,t.getCategoria().getId());
			
			pstmt.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return t;
	}

	public void delete(Integer id) {
		BibliotecaDBManager bibliotecaDBManager = new BibliotecaDBManager();
		Connection con = null;
		con = bibliotecaDBManager.obterConexaoMySQL();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("delete from tb_livro where ISBN = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Livro> list() {
		BibliotecaDBManager bibliotecaDBManager = new BibliotecaDBManager();
		ArrayList<Livro> listaCategoria = null;
		Connection con = null;
		con = bibliotecaDBManager.obterConexaoMySQL();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("select * from tb_livro");
			
			ResultSet rs = pstmt.executeQuery();
			listaCategoria = new ArrayList<Livro>();
			while (rs.next()) {
				Livro livro = new Livro();
				livro.setIsbn(rs.getInt("ISBN"));
				livro.setAutor(rs.getString("autor"));
				livro.setTitulo(rs.getString("titulo"));
				Categoria c = new Categoria();
				c.setId(rs.getInt("idCategoria"));
				
				livro.setCategoria(c);
				Editora editora = new Editora();
				editora.setId(rs.getInt("idEditora"));
				livro.setEditora(editora);
				
				listaCategoria.add(livro);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCategoria;
	}



}
