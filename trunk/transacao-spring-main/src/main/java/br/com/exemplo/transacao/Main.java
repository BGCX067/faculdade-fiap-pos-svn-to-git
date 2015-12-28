package br.com.exemplo.transacao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("application-context.xml");
		Servico bean = (Servico) context.getBean("servicePrincipal");
		bean.impressao();
	}

}
