package br.com.barbero.autoatendimento.bean;

import java.util.Date;

/***
 * Classe que define os atributos dos clientes.
 * @author Carlos Barbero
 *
 */
public class Cliente {
	
	private Long id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private Conta conta;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	
	

}
