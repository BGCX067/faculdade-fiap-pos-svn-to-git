package br.com.fiap.pizzaria.dao.generic;

import java.util.List;

public interface GenericDAO<PK, T> {

	public abstract T getById(PK pk);

	public abstract void save(T entity);

	public abstract void update(T entity);

	public abstract void delete(T entity);

	public abstract List<T> findAll();

}