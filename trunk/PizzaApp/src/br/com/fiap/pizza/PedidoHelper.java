package br.com.fiap.pizza;

public class PedidoHelper {
	private int count;
	private Object obj;

	public PedidoHelper(int count, Object obj) {
		this.count = count;
		this.obj = obj;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public void addCount() {
		this.count++;
	}

	public void subCount() {
		this.count--;
	}

	public PedidoHelper clone() {
		return new PedidoHelper(this.count, this.obj);
	}

}
