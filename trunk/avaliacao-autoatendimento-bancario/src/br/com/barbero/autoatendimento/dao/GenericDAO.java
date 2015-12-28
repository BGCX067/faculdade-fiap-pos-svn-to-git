package br.com.barbero.autoatendimento.dao;

import java.math.BigDecimal;

import br.com.barbero.autoatendimento.bean.Cliente;

/***
 * 
 * @author Alexandre Genka
 *
 * @param <T>
 */
public interface GenericDAO<T> {
	/***
	 * Metodo responsavel por disponibilizar a consulta da conta do cliente.
	 * @param id {@link Long} numero da conta do cliente.
	 * @return {@link Object} retorno genérico dependendo da implementacao do Dao.
	 */
	public T consultar(Long id);
	
	/***
	 * Metodo responsavel para permitir que o cliente possa depositar o valor solicitado.
	 * @param cliente {@link Cliente}
	 * @param valorDepositor {@link BigDecimal}
	 */
	public void depositar(Cliente cliente, BigDecimal valorDepositor);

}
