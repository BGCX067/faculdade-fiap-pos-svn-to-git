package br.com.fiap.estoque.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Reserva implements Serializable{

	private static final long serialVersionUID = 3280039570070630878L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger codigo;

	@Column
	private Date data;

	@Column
	private String atendente;

	@Column
	private String situacao;

	@Column
	private BigDecimal valor;

	@Column
	private Cliente cliente;
	
	public Reserva(){
		
	}

	public Reserva(BigInteger codigo, Date data, String atendente,
			String situacao, BigDecimal valor, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.atendente = atendente;
		this.situacao = situacao;
		this.valor = valor;
		this.cliente = cliente;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getAtendente() {
		return atendente;
	}

	public void setAtendente(String atendente) {
		this.atendente = atendente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
