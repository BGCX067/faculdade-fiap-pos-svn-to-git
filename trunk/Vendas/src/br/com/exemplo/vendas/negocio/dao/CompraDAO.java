package br.com.exemplo.vendas.negocio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.exemplo.vendas.negocio.entity.Cliente;
import br.com.exemplo.vendas.negocio.entity.Compra;

public class CompraDAO extends GenericDAO<Compra> {
	public CompraDAO(EntityManager em) {
		super(em);
	}

	public CompraDAO() {
		super(Persistence.createEntityManagerFactory("Vendas")
				.createEntityManager());
	}

	public boolean inserir(Compra compra) {
		boolean result = false;
		Compra existenteCompra = null;

		try {
			Query q = em.createQuery("from Compra where numero = :numero");
			q.setParameter("numero", compra.getNumero());

			try {
				existenteCompra = (Compra) q.getSingleResult();
			} catch (NoResultException e) {
				existenteCompra = null;
			}

			if (existenteCompra == null) {
				Cliente cliente = DaoFactory.getClienteDAO(em).find(
						compra.getCliente());
				compra.setCliente(cliente);
				
				compra.setReserva(DaoFactory.getReservaDAO(em).localizarPorId(
						compra.getReserva()));
				compra.setCliente(DaoFactory.getClienteDAO(em).find(
						compra.getCliente()));
				em.persist(compra);
			} else {
				compra.setNumero(existenteCompra.getNumero());
			}
			result = true;
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean alterar(Compra compra) {
		boolean result = false;
		Compra existenteCompra = null;

		try {
			existenteCompra = em.find(Compra.class, compra.getNumero());
			if (existenteCompra != null) {
				em.merge(compra);
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

	public boolean excluir(Compra compra) {
		Compra obj = null;
		boolean result = false;

		try {
			Query q = em.createQuery("from Compra where numero = :numero");
			q.setParameter("numero", compra.getNumero());
			obj = (Compra) q.getSingleResult();
			em.remove(obj);
			result = true;
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Compra localizarPorId(Compra compra) {
		Compra obj = null;
		boolean result = false;
		try {
			Query q = em.createQuery("from Compra where numero = :numero");
			q.setParameter("numero", compra.getNumero());
			obj = (Compra) q.getSingleResult();
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	public List<Compra> listarValorEntre() {
		List<Compra> obj = null;
		boolean result = false;
		try {
			Query q = em.createQuery("from Compra c where c.valor between 0 AND 500");
			obj = (List<Compra>) q.getResultList();
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	public List<Compra> listarComprasComReserva() {
		List<Compra> obj = null;
		boolean result = false;
		try {
			Query q = em.createQuery("from Compra c where c.reserva is not null");
			obj = (List<Compra>) q.getResultList();
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	

}