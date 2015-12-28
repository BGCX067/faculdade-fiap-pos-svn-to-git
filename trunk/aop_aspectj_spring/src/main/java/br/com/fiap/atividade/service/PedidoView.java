package br.com.fiap.atividade.service;

public class PedidoView {
	
	private String idPedido;
	private String idProduto;
	private String descricaoProduto;
	private String valorUnitario;
	private String quantidade;
	private String desconto = "";
	private String total;
	private String totalPedido;
	
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public String getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getTotalPedido() {
		return totalPedido;
	}
	
	public void setTotalPedido(String totalPedido) {
		this.totalPedido = totalPedido;
	}
	
	public String getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}
	
	
	
	@Override
	public String toString() {
		return String
				.format("PedidoView [idPedido=%s, idProduto=%s, descricaoProduto=%s, valorUnitario=%s, quantidade=%s, desconto=%s, total=%s, totalPedido=%s]",
						idPedido, idProduto, descricaoProduto, valorUnitario,
						quantidade, desconto, total, totalPedido);
	}
	
	
	
	
	
	
	
	

}
