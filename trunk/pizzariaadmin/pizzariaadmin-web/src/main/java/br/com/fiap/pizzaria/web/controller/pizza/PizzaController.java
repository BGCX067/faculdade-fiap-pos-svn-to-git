package br.com.fiap.pizzaria.web.controller.pizza;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.pizzaria.bean.Ingrediente;
import br.com.fiap.pizzaria.bean.Pizza;
import br.com.fiap.pizzaria.service.PizzaService;

@Controller
@RequestMapping("pizza")
public class PizzaController {
	
	private static final String PAGE_CADASTRO = "cadastro";
	
	@Inject
	private PizzaService pizzaService; 
	
	@RequestMapping( value = "iniciar", method=RequestMethod.GET)
	public String init(Model model){
		Pizza pizza = new Pizza();
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		Ingrediente ingrediente =  new Ingrediente();
		ingredientes.add(ingrediente);
		pizza.setIngredientes(ingredientes);
		model.addAttribute("pizza", pizza);
		return PAGE_CADASTRO;
	}
	
	@RequestMapping( value = "salvar", method=RequestMethod.POST)
	public String salvar(@ModelAttribute Pizza pizza, Model model){
		pizzaService.salvar(pizza);
		model.addAttribute("pizzas", pizzaService.listar());
		return PAGE_CADASTRO;
	}

	
	
}
