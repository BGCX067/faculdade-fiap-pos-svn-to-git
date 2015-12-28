package br.com.fiap;

import java.util.List;


public interface Carrinho  {
	
	void cadastrarItem(Item item) ;
	List<Item> obterMedicamentos() ;
	int obterQuantidadeItens() ;
	void removerCadastro(int matricula) ;


}
