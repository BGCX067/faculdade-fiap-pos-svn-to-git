package br.edu.fiap.jdbc.odbc;

import java.util.List;

public class BibliotecaNegocio {

	public void inserirLivro ( Livro livro, Editora editora ){
		LivroDAO livroDAO = new JDBCDAOFactory().createLivroDAO();
		livroDAO.insert(livro, editora);
	}
	public void excluirLivro ( String ISBN ){
		LivroDAO livroDAO = new JDBCDAOFactory().createLivroDAO();
		livroDAO.delete(Integer.valueOf(ISBN));
	}
	public List<Livro> selecionarTodosLivros( ){
		LivroDAO livroDAO = new JDBCDAOFactory().createLivroDAO();
		return livroDAO.list();
		
	}
	

}
