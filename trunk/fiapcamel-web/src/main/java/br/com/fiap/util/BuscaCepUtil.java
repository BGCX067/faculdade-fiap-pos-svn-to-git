package br.com.fiap.util;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

public class BuscaCepUtil {
	
	private Logger logger = Logger.getLogger(BuscaCepUtil.class);
	
	public  String url  = "http://buscacep.k7comunicacao.com.br/cep/{cep}/d613de5a1e98b29677b158cbe4bb5277";
	
	public String buscar(String cep, String insert){
		RestTemplate restTemplate  = new RestTemplate();
		String jsonEndereco = restTemplate.getForObject(url, String.class, cep);
		logger.info(String.format("Retorno Buscar Cep: ", jsonEndereco));
		
		StringBuilder retorno = new StringBuilder();
		retorno.append(insert.toString());
		retorno.append(jsonEndereco);
		return retorno.toString();
	}

}
