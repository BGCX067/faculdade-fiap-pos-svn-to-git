package br.com.fiap.atividade.bean;

public class Pedido {
	
	private Long idCompra;
	private Long quantidade;
	private long idProduto;
	private String descricao;
	private double valorUnitario;
	private double desconto;
	private double total;

	public void setQuantidade(long long1) {
		this.quantidade = long1;
		
	}
	
	public Long getQuantidade() {
		return quantidade;
	}

	public void setIdProduto(long long1) {
		this.idProduto = long1;
		
	}

	public void setDescricao(String string) {
		this.descricao = string;
		
	}

	public void setValorUnitario(double double1) {
		this.valorUnitario = double1;
		
	}

	public void setDesconto(double double1) {
		this.desconto = double1;
		
	}

	public void setTotal(double double1) {
		this.total = double1;
		
	}
	
	
	public double getDesconto() {
		return desconto;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public long getIdProduto() {
		return idProduto;
	}
	
	public double getTotal() {
		return total;
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}

	public Long getIdCompra() {
		return idCompra;
	}
	
	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	@Override
	public String toString() {
		return String
				.format("Pedido [idCompra=%s, quantidade=%s, idProduto=%s, descricao=%s, valorUnitario=%s, desconto=%s, total=%s]",
						idCompra, quantidade, idProduto, descricao,
						valorUnitario, desconto, total);
	}
	
	
	
	

}
