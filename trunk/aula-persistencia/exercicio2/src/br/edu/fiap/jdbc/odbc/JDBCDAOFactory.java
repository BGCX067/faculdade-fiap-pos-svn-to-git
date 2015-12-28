package br.edu.fiap.jdbc.odbc;

public class JDBCDAOFactory extends AbstractDAOFactory {

	@Override
	public CategoriaDAO createCategoriaDAO() {
		return new CategoriaDAO();
	}

	@Override
	public LivroDAO createLivroDAO() {
		return new LivroDAO();
	}

}
