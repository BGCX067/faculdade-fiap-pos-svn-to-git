package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;

import br.com.exemplo.vendas.negocio.entity.Cliente;

public class ClienteJuridicoVO extends ClienteVO implements Serializable {

	private String cnpj;

	private String ie;

	public ClienteJuridicoVO() {

	}

	public ClienteJuridicoVO(ClienteVO vo) {
		super(vo);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	@Override
	public String toString() {
		return "ClienteJuridicoVO [cnpj=" + cnpj + ", ie=" + ie + "]";
	}

}
