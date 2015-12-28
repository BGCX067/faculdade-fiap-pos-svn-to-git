package br.com.fiap.estoque.bean.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.fiap.estoque.bean.ServiceExemplo;
import br.com.fiap.estoque.bean.ServiceExemploLocal;
import br.com.fiap.estoque.bean.ServiceExemploRemote;

/***
 * Classe Ejb {@link Stateless} contendo o exemplo de implementacao
 * @author carlosrgomes@gmail.com
 *
 */
@Stateless
@Local(ServiceExemploLocal.class)
@Remote(ServiceExemploRemote.class)
public class ServiceExemploBean implements ServiceExemplo {

	@Override
	public String metodoExemplo(String value) {
		return value;
	}

}
