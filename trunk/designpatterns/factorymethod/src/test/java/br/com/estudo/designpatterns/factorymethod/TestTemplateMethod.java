package br.com.estudo.designpatterns.factorymethod;


import org.junit.Test;

import br.com.estudo.designpatterns.templatemethod.RioPreto;
import br.com.estudo.designpatterns.templatemethod.Viagem;

public class TestTemplateMethod {

	@Test
	public void testFactory(){
		Viagem viagem = new RioPreto();
		viagem.executa();
	}
}
