package br.com.fiap.pizzaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4520163872753313106L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=9, nullable=false, unique=true)
	private String telefone;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;

	@OneToMany(mappedBy="pedido")
	private List<PedidoPizza> pizzas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<PedidoPizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<PedidoPizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	

}
