package br.com.exemplo.vendas.negocio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Item implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6426176302004903672L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private BigInteger quantidade;

	@Column
	private BigDecimal valor;

	@Column
	private String situacao;

	@OneToOne(cascade = CascadeType.ALL)
	private Reserva reserva;

	@OneToOne(cascade = CascadeType.ALL)
	private Compra compra;

	@OneToOne(cascade = CascadeType.ALL)
	private Produto produto;

	public Item() {
	}

	public Item(BigInteger quantidade, BigDecimal valor, String situacao,
			Reserva reserva, Compra compra, Produto produto, Integer id) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.situacao = situacao;
		this.reserva = reserva;
		this.compra = compra;
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigInteger getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigInteger quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
