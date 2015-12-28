package br.com.exemplo.dozer;

import org.dozer.Mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.entity.Pessoa;
import br.com.vo.PessoaVO;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application.xml");
		
		
		  Mapper mapper = (Mapper) context.getBean("mapper");
		  
		  PessoaVO pessoaVO =  new PessoaVO();
		  pessoaVO.setNme("Carlos");
		  pessoaVO.setNascimento("18/05/1982");
		  
		  Pessoa pessoa = mapper.map(pessoaVO, Pessoa.class);
		  
		  System.out.println(pessoa.getNome());
		  System.out.println(pessoa.getNascimento());

	}
}
