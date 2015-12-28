package br.com.fiap.pizzaria.service;

import java.util.List;

import br.com.fiap.pizzaria.bean.Pizza;

public interface PizzaService {

	public void salvar(Pizza pizza);
	
	public List<Pizza> listar();
	
}
