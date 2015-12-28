package br.com.fiap.estoque.bean.entity;

import javax.persistence.Column;

public class ClienteFisico extends Cliente {

	private static final long serialVersionUID = -201445427728095064L;

	@Column
	private String RG;
	
	@Column
	private String CPF;

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

}
