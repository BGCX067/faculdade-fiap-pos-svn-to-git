package br.com.exemplo.vendas.rest;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.exemplo.vendas.apresentacao.service.ServiceProduto;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Path("/produto")
public class ProdutoRest {

	@GET
	@Path("/listarPorPrecoEstoque")
	@Produces(MediaType.APPLICATION_XML)
	public ProdutoVO[] listarPorPrecoEstoque() throws LayerException {
		ServiceProduto service = new ServiceProduto();
		ProdutoVO[] produtos = service.listarPorPrecoEstoque();
		return produtos;
	}

}