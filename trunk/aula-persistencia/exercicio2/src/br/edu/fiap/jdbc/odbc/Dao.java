package br.edu.fiap.jdbc.odbc;

import java.util.List;

public interface Dao<T> {
	
	public T insert(T t);
	public void delete(Integer id);
	public List<T> list();
	public T update(T t);

}
