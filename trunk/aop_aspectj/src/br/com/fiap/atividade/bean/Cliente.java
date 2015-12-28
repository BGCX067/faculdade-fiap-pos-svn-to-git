package br.com.fiap.atividade.bean;

import java.util.Date;

import br.com.fiap.aop.aspectj.TipoCliente;

public class Cliente {
	
	private Long id;
	private String nome;
	private TipoCliente tipoCliente;
	private Produto produto;
	private Date dataCompra;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void setDataCompra(Date data) {
		this.dataCompra = data;
	}

	public Date getDataCompra() {
		return dataCompra;
	}
	
	
	

}
