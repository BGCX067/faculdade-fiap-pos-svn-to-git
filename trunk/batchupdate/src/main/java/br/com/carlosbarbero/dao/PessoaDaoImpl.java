package br.com.carlosbarbero.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.carlosbarbero.Pessoa;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class PessoaDaoImpl implements PessoaDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public void inserir(List<Pessoa> lista) {
		String sql = "insert into pessoa(name) values(:name)";
		
		SqlParameterSource[] parametros = SqlParameterSourceUtils.createBatch(lista.toArray());
		
		jdbc.batchUpdate(sql, parametros);

	}

}
