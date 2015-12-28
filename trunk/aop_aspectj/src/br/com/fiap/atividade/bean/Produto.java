package br.com.fiap.atividade.bean;

import java.math.BigDecimal;

public class Produto {
	
	private Long id;
	private String dscProduto;
	private BigDecimal vlrUnitario;
	private Long qtd;
	private Double desconto;
	private BigDecimal total;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDscProduto() {
		return dscProduto;
	}
	public void setDscProduto(String dscProduto) {
		this.dscProduto = dscProduto;
	}
	public BigDecimal getVlrUnitario() {
		return vlrUnitario;
	}
	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}
	public Long getQtd() {
		return qtd;
	}
	public void setQtd(Long qtd) {
		this.qtd = qtd;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
	

}
