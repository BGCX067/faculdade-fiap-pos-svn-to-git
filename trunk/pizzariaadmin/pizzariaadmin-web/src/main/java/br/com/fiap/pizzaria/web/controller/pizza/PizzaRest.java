package br.com.fiap.pizzaria.web.controller.pizza;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pizzaria.bean.Pizza;
import br.com.fiap.pizzaria.service.PizzaService;

@RestController
@RequestMapping("pizza/rest")
public class PizzaRest {
	
	@Inject
	private PizzaService pizzaService;

	
	@RequestMapping(value="salvar", method=RequestMethod.POST, consumes={"application/xml", "application/json"}, produces={"application/xml", "application/json"})
	@ResponseStatus(HttpStatus.OK)
	public void salvar(@RequestBody Pizza pizza){
		pizzaService.salvar(pizza);
	}
	
}
