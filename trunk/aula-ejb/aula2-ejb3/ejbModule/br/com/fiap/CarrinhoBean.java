package br.com.fiap;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless
@Remote(CarrinhoRemote.class)
@Local(CarrinhoLocal.class)
public class CarrinhoBean  implements Carrinho   {
	
	private List<Item> itens = new ArrayList<Item>();

	public void cadastrarItem(Item item)  {
		System.out.println("Item cadastrado com sucesso: " + item.getNome());
	}

	public List<Item> obterMedicamentos()  {
		return this.itens;

	}

	public int obterQuantidadeItens() {
		return this.itens.size();
	}

	public void removerCadastro(int matricula)  {
		if(this.itens != null && this.itens.size() > 0){
			this.itens.remove(matricula);
		}
		
	}



	

}
