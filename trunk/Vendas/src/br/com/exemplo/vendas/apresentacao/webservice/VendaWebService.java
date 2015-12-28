package br.com.exemplo.vendas.apresentacao.webservice;

import br.com.exemplo.vendas.apresentacao.service.ServiceCliente;
import br.com.exemplo.vendas.apresentacao.service.ServiceCompra;
import br.com.exemplo.vendas.apresentacao.service.ServiceProduto;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class VendaWebService implements VendaWebServiceInterface{
	public ClienteVO[] selecionarClientesComCompra() throws LayerException {
		ServiceCliente service = new ServiceCliente();
		ClienteVO[] clientes = service.selecionarClientesComCompra();
		return clientes;
	}

	public CompraVO[] listarValorEntre() throws LayerException {
		ServiceCompra service = new ServiceCompra();
		CompraVO[] lista = service.listarValorEntre();
		return lista;
	}

	public CompraVO[] listarComprasComReserva() throws LayerException {
		ServiceCompra service = new ServiceCompra();
		CompraVO[] lista = service.listarComprasComReserva();
		return lista;
	}

	public ProdutoVO[] listarPorPrecoEstoque() throws LayerException {
		ServiceProduto service = new ServiceProduto();
		ProdutoVO[] produtos = service.listarPorPrecoEstoque();
		return produtos;
	}
}
