package br.com.exemplo.vendas.negocio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class ClienteFisico extends Cliente implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4096229010954491432L;

	public ClienteFisico(Integer id, String nome, String endereco,
			String telefone, String situacao) {
		super(id, nome, endereco, telefone, situacao);
	}
	
	public ClienteFisico(){
		
	}
	
	public ClienteFisico(Cliente cliente) {
		super(cliente);
	}


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
