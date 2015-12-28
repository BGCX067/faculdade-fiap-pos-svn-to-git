package br.com.churchsolutions;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Visitante {
	
	@Id
	private String id;
	
	@Field
	private String telefone;
	
	@Field
	private String nome;
	
	@Field
	private Date dataNascimento;
	
	@Field
	private Date dataHoraVisita;
	
	@Field
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataHoraVisita() {
		return dataHoraVisita;
	}

	public void setDataHoraVisita(Date dataHoraVisita) {
		this.dataHoraVisita = dataHoraVisita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String
				.format("Visitante [id=%s, telefone=%s, nome=%s, dataNascimento=%s, dataHoraVisita=%s, email=%s]",
						id, telefone, nome, dataNascimento, dataHoraVisita,
						email);
	}
	
	

}
