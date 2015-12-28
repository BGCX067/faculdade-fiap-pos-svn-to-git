package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import br.com.exemplo.vendas.negocio.entity.Compra;
import br.com.exemplo.vendas.negocio.entity.Produto;
import br.com.exemplo.vendas.negocio.entity.Reserva;

public class ItemVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4658321814604753364L;

	private Integer id;

	private BigInteger quantidade;

	private BigDecimal valor;

	private String situacao;

	private Reserva reserva;

	private Compra compra;

	private Produto produto;

	public ItemVO() {
	}

	public ItemVO(BigInteger quantidade, BigDecimal valor, String situacao,
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
