package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;

import br.com.exemplo.vendas.negocio.entity.Cliente;

public class ClienteFisicoVO extends ClienteVO implements Serializable {

	private String cpf;
	
	private String RG;
	
	public ClienteFisicoVO(){
	}
	
	public ClienteFisicoVO(ClienteVO clienteVO){
		super(clienteVO);
	}
	
	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
