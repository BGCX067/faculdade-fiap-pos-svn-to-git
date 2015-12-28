package br.com.exemplo.vendas.apresentacao.webservice;

import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public interface VendaWebServiceInterface {
	public ClienteVO[] selecionarClientesComCompra() throws LayerException;

	public CompraVO[] listarValorEntre() throws LayerException;

	public CompraVO[] listarComprasComReserva() throws LayerException;

	public ProdutoVO[] listarPorPrecoEstoque() throws LayerException;
}
