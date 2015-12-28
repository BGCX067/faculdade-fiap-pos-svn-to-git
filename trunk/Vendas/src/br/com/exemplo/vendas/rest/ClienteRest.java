package br.com.exemplo.vendas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.exemplo.vendas.apresentacao.service.ServiceCliente;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Path("/cliente")
public class ClienteRest {

	@GET
	@Path("/selecionarClientesComCompra")
	@Produces(MediaType.APPLICATION_XML)
	public ClienteVO[] selecionarClientesComCompra() throws LayerException{
		System.out.println("ENTROU REST**********************************");
		ServiceCliente service = new ServiceCliente();
		ClienteVO[] clientes = service.selecionarClientesComCompra();
		return clientes;
	}
}
