package br.com.fiap.pizzaria.bean;

import java.io.Serializable;

public class PedidoPizzaId implements Serializable {
	
	private static final long serialVersionUID = 8307208175285672118L;
	private int pedido;
	private int pizza;
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	public int getPizza() {
		return pizza;
	}
	public void setPizza(int pizza) {
		this.pizza = pizza;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pedido;
		result = prime * result + pizza;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoPizzaId other = (PedidoPizzaId) obj;
		if (pedido != other.pedido)
			return false;
		if (pizza != other.pizza)
			return false;
		return true;
	}
	
	

}
