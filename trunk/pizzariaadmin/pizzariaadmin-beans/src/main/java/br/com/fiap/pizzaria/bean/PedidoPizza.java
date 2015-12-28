package br.com.fiap.pizzaria.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pedido_pizza")
@IdClass(PedidoPizzaId.class)
public class PedidoPizza implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5990653684157421595L;

	@Id
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@Id
	@ManyToOne
	@JoinColumn(name="pizza_id")
	private Pizza pizza;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	
	
}
