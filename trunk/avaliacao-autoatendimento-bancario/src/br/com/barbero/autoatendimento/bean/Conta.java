package br.com.barbero.autoatendimento.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/***
 * Classe que define os atributos de todas as contas do sistema.
 * @author Carlos Barbero
 *
 */
public class Conta {
	
	private Long id;
	private BigDecimal saldoDaConta;
	private Date data;
	private TipoConta tipoConta;
	private List<Extrato> operacoes;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getSaldoDaConta() {
		return saldoDaConta;
	}
	public void setSaldoDaConta(BigDecimal saldoDaConta) {
		this.saldoDaConta = saldoDaConta;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public List<Extrato> getOperacoes() {
		return operacoes;
	}
	
	public void setOperacoes(List<Extrato> operacoes) {
		this.operacoes = operacoes;
	}
}
