package br.com.carlosbarbero;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.carlosbarbero.dao.PessoaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestPessoaDao {

	@Autowired
	private PessoaDao pessoaDao;

	@Test
	public void inserir() {

		List<Pessoa> lista = new ArrayList<Pessoa>();

		for (int i = 0; i < 50000; i++) {
			Pessoa pessoa = new Pessoa();
			pessoa.setName("Carlos" + i);
			lista.add(pessoa);
		}

		pessoaDao.inserir(lista);

		System.out.println("inseriu");

	}

}
