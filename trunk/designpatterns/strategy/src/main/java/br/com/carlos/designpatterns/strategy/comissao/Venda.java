package br.com.carlos.designpatterns.strategy.comissao;

public class Venda {

	private double valorVenda;
    private Funcionario funcionario;    

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	 public double salvar() {
         double valorComissao = this.funcionario.getCargo().calcularComissao(this.valorVenda);
         return valorComissao;
	}
     
}
