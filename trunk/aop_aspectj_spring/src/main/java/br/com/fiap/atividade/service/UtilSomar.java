package br.com.fiap.atividade.service;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sum;

import java.util.Date;
import java.util.List;

import br.com.fiap.atividade.bean.Pedido;

public class UtilSomar {

	public UtilSomar() {
		super();
	}

	public Double somar(List<Pedido> pedidos, Date data) {
		Double valDouble = sum(pedidos, on(Pedido.class).getValorUnitario());
		return valDouble;
	}

}