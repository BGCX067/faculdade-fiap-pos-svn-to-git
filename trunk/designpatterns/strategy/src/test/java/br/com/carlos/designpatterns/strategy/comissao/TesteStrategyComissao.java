package br.com.carlos.designpatterns.strategy.comissao;

import org.junit.Assert;
import org.junit.Test;

public class TesteStrategyComissao {
	
	@Test
	public void testComissaoAtendente(){
		Venda venda =  new Venda();
		venda.setValorVenda(10);
		Funcionario funcionario = new Funcionario();
		funcionario.setCargo(Cargo.ATENDENTE);
		venda.setFuncionario(funcionario);
		double valorComissao = venda.salvar();
		Assert.assertEquals("Comissao do Atendente: ", 0.1d, valorComissao, 0d);
	}
	
	@Test
	public void testComissaoGerente(){
		Venda venda =  new Venda();
		venda.setValorVenda(10);
		Funcionario funcionario = new Funcionario();
		funcionario.setCargo(Cargo.GERENTE);
		venda.setFuncionario(funcionario);
		double valorComissao = venda.salvar();
		Assert.assertEquals("Comissao do Atendente: ", 100.3d, valorComissao, 0d);
	}
	
	@Test
	public void testComissaoVendedor(){
		Venda venda =  new Venda();
		venda.setValorVenda(10);
		Funcionario funcionario = new Funcionario();
		funcionario.setCargo(Cargo.VENDEDOR);
		venda.setFuncionario(funcionario);
		double valorComissao = venda.salvar();
		Assert.assertEquals("Comissao do Atendente: ", 0.2d, valorComissao, 0d);
	}

}
