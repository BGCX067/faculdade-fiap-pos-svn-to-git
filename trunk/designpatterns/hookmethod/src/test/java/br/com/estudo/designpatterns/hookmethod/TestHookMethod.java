package br.com.estudo.designpatterns.hookmethod;

import org.junit.Test;

public class TestHookMethod {
	
	@Test
	public void testService(){
		Service service =  new ServiceImpl();
		service.execute();
	}

}
