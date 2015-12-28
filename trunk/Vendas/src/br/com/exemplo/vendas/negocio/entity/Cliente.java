package br.com.exemplo.vendas.negocio.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3545009067181834222L;



	public Cliente(){
		
	}
	
	public Cliente(Integer id){
		this.id = id;
	}

	public Cliente(Cliente cliente){
		this(cliente.getId(), cliente.getNome(), cliente.getEndereco(),
				cliente.getTelefone(), cliente.getSituacao());
	}

	public Cliente(Integer id, String nome, String endereco, String telefone,
			String situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.situacao = situacao;
	}
	
	public Cliente(ClienteVO vo) {
		super();
		this.id = vo.getId();
		this.nome = vo.getNome();
		this.endereco = vo.getEndereco();
		this.telefone = vo.getTelefone();
		this.situacao = vo.getSituacao();
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String nome;

	@Column
	private String endereco;

	@Column
	private String telefone;

	@Column
	private String situacao;



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

}
