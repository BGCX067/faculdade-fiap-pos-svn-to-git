package br.com.exemplo.vendas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.exemplo.vendas.apresentacao.service.ServiceReserva;
import br.com.exemplo.vendas.negocio.model.vo.ReservaVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Path("/reserva")
public class ReservaRest {

	@GET
	@Path("/pedidosDia")
	@Produces(MediaType.APPLICATION_JSON)
	public ReservaVO[] pedidosDia() throws LayerException{
		ServiceReserva service = new ServiceReserva();
		ReservaVO[] reservas = service.pedidosDia();
		return reservas;
	}
	
}
