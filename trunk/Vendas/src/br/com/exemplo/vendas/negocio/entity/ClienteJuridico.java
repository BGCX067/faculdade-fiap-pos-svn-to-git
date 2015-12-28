package br.com.exemplo.vendas.negocio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ClienteJuridico extends Cliente implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1974370346224922714L;

	public ClienteJuridico() {

	}

	public ClienteJuridico(Cliente cliente) {
		super(cliente);
	}

	public ClienteJuridico(Integer id, String nome, String endereco,
			String telefone, String situacao) {
		super(id, nome, endereco, telefone, situacao);
	}

	@Column
	private String CNPJ;

	@Column
	private String IE;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getIE() {
		return IE;
	}

	public void setIE(String iE) {
		IE = iE;
	}
}
