package br.com.dietapontos.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="alimentos_usuario")
public class AlimentosUsuario {

	@Id
	private Long id;
	
	@JoinColumn
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Usuario usuario;
	
	@JoinColumn
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Alimentos alimentos;
	
	@Column
	private Date data;
	
	@Column
	private int gramas;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Alimentos getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(Alimentos alimentos) {
		this.alimentos = alimentos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getGramas() {
		return gramas;
	}

	public void setGramas(int gramas) {
		this.gramas = gramas;
	}
	
	
}
