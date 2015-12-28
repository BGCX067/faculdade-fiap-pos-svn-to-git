package br.com.fiap.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanSpring {
	
	private static ApplicationContext context;
	
	static{
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
	}
	
	public static Object  getBean(String bean) {
		return context.getBean(bean);
	}
	

}
