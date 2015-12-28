package br.com.fiap.estoque.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Service;


@Service
@WebService(serviceName="ServicoExemploSoap" )
public class ServicoExemploSoap implements ServiceExemplo {
	

	@WebMethod(operationName="impressao")
	public String imprimir(String value){
		return value;
	}

}
