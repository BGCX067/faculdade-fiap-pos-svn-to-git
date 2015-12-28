import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.artigo.restvalidation.bean.Comentario;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:testapplication.xml"})
public class TestPostComentario {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	public void teste() throws RestClientException, URISyntaxException{
		String jsonStringUser = "{ \"texto\": \"Teste\" }";
		
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType( MediaType.APPLICATION_JSON );

	        HttpEntity request= new HttpEntity( jsonStringUser, headers );
		
		Comentario postForObject = restTemplate.postForObject("http://localhost:8080/comentario/adicionar", request, Comentario.class);

	}

}
