package br.com.fiap.estoque.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Compra implements Serializable{

	private static final long serialVersionUID = 7517555228807224810L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger numero;

	@Column
	private Date data;

	@Column
	private String responsavel;

	@Column
	private String situacao;

	@Column
	private BigDecimal valor;

	@Column
	private Reserva reserva;

	@Column
	private Cliente cliente;

	public Compra(){
		
	}
			
	public Compra(BigInteger numero, Date data, String responsavel,
			String situacao, BigDecimal valor, Reserva reserva, Cliente cliente) {
		super();
		this.numero = numero;
		this.data = data;
		this.responsavel = responsavel;
		this.situacao = situacao;
		this.valor = valor;
		this.reserva = reserva;
		this.cliente = cliente;
	}

	public BigInteger getNumero() {
		return numero;
	}

	public void setNumero(BigInteger numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
