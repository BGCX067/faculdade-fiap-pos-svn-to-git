package br.com.barbero.autoatendimento.bean;

import java.math.BigDecimal;
import java.util.Date;

/***
 * Classe que representa o bean de Extrato.
 * @author Alexandre Genka
 *
 */
public class Extrato {
	
	private Date dataOperacao;
	private TipoOperacao tipoDaOperacao;
	
	private BigDecimal valor;
	
	public Date getDataOperacao() {
		return dataOperacao;
	}
	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public TipoOperacao getTipoDaOperacao() {
		return tipoDaOperacao;
	}
	
	public void setTipoDaOperacao(TipoOperacao tipoDaOperacao) {
		this.tipoDaOperacao = tipoDaOperacao;
	}
	

}
