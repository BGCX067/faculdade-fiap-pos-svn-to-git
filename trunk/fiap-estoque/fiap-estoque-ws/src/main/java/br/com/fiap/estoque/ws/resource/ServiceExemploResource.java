package br.com.fiap.estoque.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.fiap.estoque.bean.ServiceExemplo;


@Component
@Path("service-exemplo")
public class ServiceExemploResource {
	
	@Autowired
	@Qualifier("serviceExemplo")
	private ServiceExemplo serviceExemplo;
	
	
	@GET
	@Path("/metodo")
	public Response metodoRest(@QueryParam("nome") String nome) {
		return Response.status(200).entity(serviceExemplo.metodoExemplo(nome)).build();
	}

}
