package br.com.dietapontos.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alimentos")
public class Alimentos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idAlimento;

	@Column(unique = true)
	private String nome;

	@Column
	private int calorias;

	@Column(nullable = false, columnDefinition = "VARCHAR(15)")
	@Enumerated(EnumType.STRING)
	private TipoAlimento tipoAlimento;

	public long getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(long idAlimento) {
		this.idAlimento = idAlimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public TipoAlimento getTipoAlimento() {
		return tipoAlimento;
	}

	public void setTipoAlimento(TipoAlimento tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}

}
