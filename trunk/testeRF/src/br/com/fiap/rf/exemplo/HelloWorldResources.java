package br.com.fiap.rf.exemplo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
public class HelloWorldResources {

	@GET
	@Produces("text/plain")
	public String showHelloWorld() {
		return "Ola mundo";
	}
}