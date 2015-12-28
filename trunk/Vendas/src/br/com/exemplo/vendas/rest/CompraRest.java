package br.com.exemplo.vendas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.exemplo.vendas.apresentacao.service.ServiceCompra;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Path("/compra")
public class CompraRest {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/listarValorEntre")
	public CompraVO[] listarValorEntre() throws LayerException{
		ServiceCompra service = new ServiceCompra();
		CompraVO[] lista = service.listarValorEntre();
		return lista;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/listarComprasComReserva")
	public CompraVO[] listarComprasComReserva() throws LayerException{
		ServiceCompra service = new ServiceCompra();
		CompraVO[] lista = service.listarComprasComReserva();
		return lista;
	}
}