package br.com.fiap.pizzaria.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.fiap.pizzaria.bean.Endereco;
import br.com.fiap.pizzaria.bean.Imagem;
import br.com.fiap.pizzaria.bean.Ingrediente;
import br.com.fiap.pizzaria.bean.Pedido;
import br.com.fiap.pizzaria.bean.PedidoPizza;
import br.com.fiap.pizzaria.bean.Pizza;
import br.com.fiap.pizzaria.bean.Tamanho;
import br.com.fiap.pizzaria.dao.pedido.PedidoDao;
import br.com.fiap.pizzaria.dao.pizza.PizzaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context-test.xml"})
public class PizzaDaoTest {
	
	@Inject
	private PizzaDao pizzaDao;
	
	@Inject
	private PedidoDao pedidoDao;
	
	private InputStream resourceAsStream;
	
	@Test
	public void testPizzaDaoSave() throws IOException{
		Pizza pizza =  new Pizza();
		pizza.setSabor("Mussarela");
		pizza.setTamanho(Tamanho.PEQUENO);
		pizza.setValor(new BigDecimal(10.0d));
		List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setDescricao("queijo Mussarela");
		ingredientes.add(ingrediente);
		
		URL url =  ClassLoader.getSystemResource("teste.jpg");
		
		resourceAsStream = new FileInputStream(url.getFile());
		
		byte[] bytes = IOUtils.toByteArray(resourceAsStream);

		Imagem imagem = new Imagem();
		imagem.setImagem(bytes);
		imagem.setNome("teste.jpg");
		pizza.setImagem(imagem);
		pizza.setIngredientes(ingredientes);
		pizzaDao.save(pizza);
		
		
		List<Pizza> findAll = pizzaDao.findAll();
		Assert.assertEquals(1, findAll.size());
		
		Pedido pedido = new Pedido();
		Endereco endereco = new Endereco();
		endereco.setCep("05001000");
		endereco.setLogradouro("Av Francisco Matarazzo 108");
		endereco.setNumero("108");
		pedido.setEndereco(endereco);
		PedidoPizza pedidoPizza = new PedidoPizza();
		pedidoPizza.setDataPedido(new Date());
		pedidoPizza.setPizza(findAll.get(0));
		pedido.setTelefone("981013600");
		
		List<PedidoPizza> lisPedidoPizzas = new ArrayList<PedidoPizza>();
		lisPedidoPizzas.add(pedidoPizza);
		pedido.setPizzas(lisPedidoPizzas);
		
		ObjectMapper mapper = new ObjectMapper();
		StringWriter stringWriter = new StringWriter();
		
		mapper.writeValue(stringWriter, pizza);
		
		System.out.println(stringWriter.toString());

		pedidoDao.save(pedido);
		
		
	}
	

}
