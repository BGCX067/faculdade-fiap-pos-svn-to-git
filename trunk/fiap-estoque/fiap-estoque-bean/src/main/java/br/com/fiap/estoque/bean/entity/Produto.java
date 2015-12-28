package br.com.fiap.estoque.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Produto implements Serializable{

	private static final long serialVersionUID = -1779662681972655266L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger codigo;

	@Column
	private String descricao;

	@Column
	private BigDecimal preco;

	@Column
	private String estoque;
	
	public Produto(BigInteger codigo, String descricao, BigDecimal preco,
			String estoque) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}

	public Produto() {
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

}
