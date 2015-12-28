package br.com.fiap.pizzaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="ingrediente")
public class Ingrediente implements Serializable{

	
	private static final long serialVersionUID = 1718304257219564392L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=255)
	private String descricao;
	
	@ManyToMany(mappedBy="ingredientes", fetch=FetchType.LAZY)
	private List<Pizza> pizza;
	
	public List<Pizza> getPizza() {
		return pizza;
	}
	
	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
