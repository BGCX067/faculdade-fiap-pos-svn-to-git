package br.com.controleaereo.dao;

import java.util.List;

public interface GenericDAO<T> {
	public List<T> listAll();
	public T find(Long id);
	public T update(T t);
	public T save(T t) throws Exception;
	public void delete(T t);
}
