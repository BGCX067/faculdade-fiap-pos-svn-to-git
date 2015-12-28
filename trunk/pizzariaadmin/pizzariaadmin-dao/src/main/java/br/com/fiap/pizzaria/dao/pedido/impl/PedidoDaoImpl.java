package br.com.fiap.pizzaria.dao.pedido.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.pizzaria.bean.Pedido;
import br.com.fiap.pizzaria.dao.generic.GenericDAOImpl;
import br.com.fiap.pizzaria.dao.pedido.PedidoDao;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class PedidoDaoImpl extends GenericDAOImpl<Long, Pedido> implements PedidoDao {

	

}
