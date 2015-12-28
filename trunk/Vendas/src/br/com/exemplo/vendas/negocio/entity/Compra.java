package br.com.exemplo.vendas.negocio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Compra implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6101755760977795689L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numero;

	@Column
	private Date data;

	@Column
	private String responsavel;

	@Column
	private String situacao;

	@Column
	private BigDecimal valor;

	@OneToOne(cascade = CascadeType.ALL)
	private Reserva reserva;

	@OneToOne(cascade = CascadeType.ALL)
	private Cliente cliente;

	public Compra(){
		
	}
	public Compra(Integer numero){
		this.numero = numero;
	}	
			
	public Compra(Integer numero, Date data, String responsavel,
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
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
