package br.com.fiap.pizzaria.dao.pedido.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.pizzaria.bean.PedidoPizza;
import br.com.fiap.pizzaria.dao.generic.GenericDAOImpl;
import br.com.fiap.pizzaria.dao.pedido.PedidoPizzaDao;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class PedidoPizzaDaoImpl extends GenericDAOImpl<Long, PedidoPizza> implements PedidoPizzaDao {

	
}
