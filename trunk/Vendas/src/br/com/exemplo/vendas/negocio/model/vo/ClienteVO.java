package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.exemplo.vendas.negocio.entity.Cliente;

@XmlRootElement(name="ClienteVO")
public class ClienteVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6114560390106301210L;

	private Integer id;

	private String nome;

	private String endereco;

	private String telefone;

	private String situacao;

	public ClienteVO(ClienteVO vo) {
		this.id = vo.getId();
		this.nome = vo.getNome();
		this.endereco = vo.getEndereco();
		this.telefone = vo.getTelefone();
		this.situacao = vo.getSituacao();
	}
	

	public ClienteVO(Integer id, String nome, String endereco, String telefone,
			String situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "ClienteVO [id=" + id + ", nome=" + nome + ", endereco="
				+ endereco + ", telefone=" + telefone + ", situacao="
				+ situacao + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public ClienteVO() {
	}

}
