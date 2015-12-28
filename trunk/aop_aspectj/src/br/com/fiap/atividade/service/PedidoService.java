package br.com.fiap.atividade.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.lambdaj.group.Group;

import br.com.fiap.atividade.bean.Pedido;
import br.com.fiap.atividade.util.UtilFormatter;
import static ch.lambdaj.Lambda.*;


public class PedidoService {
	
	
	public  List<PedidoView> sumarizar(List<Pedido> pedidos, Date date){
		
		
		Double valorTotal = somar(pedidos, date);
		
		Group<Pedido> lista = group(pedidos, by(on(Pedido.class).getDescricao()));  
		ArrayList<PedidoView> listaPedidoViews = new ArrayList<PedidoView>();
		
		for (Group<Pedido> listaP : lista.subgroups()) {
			PedidoView pedidoView = new PedidoView();
			pedidoView.setIdPedido(String.valueOf(listaP.findAll().get(0).getIdCompra()));
			pedidoView.setTotalPedido(UtilFormatter.converToString(valorTotal));
			pedidoView.setQuantidade(String.valueOf(listaP.getSize()));
			pedidoView.setDescricaoProduto(listaP.findAll().get(0).getDescricao());
			pedidoView.setIdProduto(String.valueOf(listaP.findAll().get(0).getIdProduto()));
			pedidoView.setValorUnitario(UtilFormatter.converToString(listaP.findAll().get(0).getValorUnitario()));
			pedidoView.setDesconto(UtilFormatter.converToString(listaP.findAll().get(0).getDesconto()));
			Double total = 0d;
			for (int i = 0; i < listaP.getSize(); i++) {
				total+= listaP.findAll().get(i).getValorUnitario();
			}
			pedidoView.setTotal(UtilFormatter.converToString(total));
			listaPedidoViews.add(pedidoView);
		}
		
		return listaPedidoViews;
		
	}

	private Double somar(List<Pedido> pedidos, Date data) {
		Double valDouble = sum(pedidos, on(Pedido.class).getValorUnitario());
		return valDouble;
	}
	
	
	

}
