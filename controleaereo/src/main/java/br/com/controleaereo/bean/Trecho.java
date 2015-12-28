package br.com.controleaereo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trecho")
public class Trecho implements Serializable {

	private static final long serialVersionUID = 8549087160166926471L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String nomeTrecho1;

	@Column(nullable = false)
	private String nomeTrecho2;

	@Column(nullable = false)
	private Double preco;

	@Column(nullable = false)
	private String dataHora;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTrecho1() {
		return nomeTrecho1;
	}

	public void setNomeTrecho1(String nomeTrecho1) {
		this.nomeTrecho1 = nomeTrecho1;
	}

	public String getNomeTrecho2() {
		return nomeTrecho2;
	}

	public void setNomeTrecho2(String nomeTrecho2) {
		this.nomeTrecho2 = nomeTrecho2;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeTrecho1 == null) ? 0 : nomeTrecho1.hashCode());
		result = prime * result
				+ ((nomeTrecho2 == null) ? 0 : nomeTrecho2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Trecho other = (Trecho) obj;
		if (nomeTrecho1 == null) {
			if (other.nomeTrecho1 != null) {
				return false;
			}
		} else if (!nomeTrecho1.equals(other.nomeTrecho1)) {
			return false;
		}
		if (nomeTrecho2 == null) {
			if (other.nomeTrecho2 != null) {
				return false;
			}
		} else if (!nomeTrecho2.equals(other.nomeTrecho2)) {
			return false;
		}
		return true;
	}

}
