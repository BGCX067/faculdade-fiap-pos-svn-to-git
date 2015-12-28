package br.com.fiap.estoque.bean.entity;

import javax.persistence.Column;

public class ClienteJuridico extends Cliente {

	private static final long serialVersionUID = 1540832604941937922L;

	@Column
	private String CNPJ;
	
	@Column
	private String endereco;
	
	@Column
	private String IE;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getIE() {
		return IE;
	}

	public void setIE(String iE) {
		IE = iE;
	}
}
