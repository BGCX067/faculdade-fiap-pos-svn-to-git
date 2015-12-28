package br.edu.fiap.jdbc.odbc;

import java.util.List;
import java.util.Random;

public class BibliotecaTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random randomGenerator = new Random();
		CategoriaDAO categoriaDAO = new JDBCDAOFactory().createCategoriaDAO();
		Categoria categoria = new Categoria();
		categoria.setId(randomGenerator.nextInt(100));
		categoria.setDescricao("Java");
		categoriaDAO.insert(categoria);
		
		
		BibliotecaNegocio negocio = new BibliotecaNegocio();
		Livro t = new Livro();
		t.setIsbn(randomGenerator.nextInt(100));
		t.setAutor("Barbero");
		categoria.setId(1);
		t.setCategoria(categoria);
		Editora editora = new Editora();
		editora.setNome("Barberos");
		t.setEditora(editora);
		t.setTitulo("Barbero Solutions Como programar");
		negocio.inserirLivro(t, editora);
		
		List<Livro> selecionarTodosLivros = negocio.selecionarTodosLivros();
		
		System.out.println("Listando Livros");
		
		for (Livro livro : selecionarTodosLivros) {
			System.out.println(livro.getTitulo());
		}
		
	}

}
