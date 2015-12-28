package br.com.fiap.pizzaria.dao.pizza.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.pizzaria.bean.Pizza;
import br.com.fiap.pizzaria.dao.generic.GenericDAOImpl;
import br.com.fiap.pizzaria.dao.pizza.PizzaDao;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class PizzaDaoImpl extends GenericDAOImpl<Long, Pizza> implements PizzaDao {
	


}
