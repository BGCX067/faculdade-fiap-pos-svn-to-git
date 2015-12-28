package br.com.exemplo.vendas.negocio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.exemplo.vendas.negocio.entity.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {
	public ClienteDAO(EntityManager em) {
		super(em);
	}

	public ClienteDAO() {
		super(Persistence.createEntityManagerFactory("Vendas")
				.createEntityManager());
	}

	public boolean inserir(Cliente cliente) {
		boolean result = false;
		Cliente existenteCliente = null;

		try {
			Query q = em.createQuery("from Cliente where id = :id");
			q.setParameter("id", cliente.getId());

			try {
				existenteCliente = (Cliente) q.getSingleResult();
			} catch (NoResultException e) {
				existenteCliente = null;
			}

			if (existenteCliente == null) {
				em.persist(cliente);
			} else {
				cliente.setId(existenteCliente.getId());
			}
			result = true;
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean alterar(Cliente cliente) {
		boolean result = false;
		Cliente existenteCliente = null;

		try {
			existenteCliente = em.find(Cliente.class, cliente.getId());
			if (existenteCliente != null) {
				em.merge(cliente);
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
			result = false;
		}
		return result;
	}

	public boolean excluir(Cliente cliente) {
		Cliente obj = null;
		boolean result = false;

		try {
			Query q = em.createQuery("from Cliente where id = :id");
			q.setParameter("id", cliente.getId());
			obj = (Cliente) q.getSingleResult();
			em.remove(obj);
			result = true;
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Cliente find(Cliente cliente) {
		Cliente obj = null;
		boolean result = false;
		try {
			Query q = em.createQuery("from Cliente where id = :id");
			q.setParameter("id", cliente.getId());
			obj = (Cliente) q.getSingleResult();
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	public List<Cliente> selecionarClientesComCompra() {
		List<Cliente> obj = null;
		try {
			Query q = em.createQuery("from Cliente cli INNER JOIN Compra com");
			obj =  (List<Cliente>)q.getResultList();
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	

}