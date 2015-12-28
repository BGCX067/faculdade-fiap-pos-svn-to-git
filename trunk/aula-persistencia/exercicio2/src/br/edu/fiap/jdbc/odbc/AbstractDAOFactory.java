package br.edu.fiap.jdbc.odbc;

public abstract class AbstractDAOFactory {

	public abstract CategoriaDAO createCategoriaDAO();
	public abstract LivroDAO createLivroDAO();
	
}
