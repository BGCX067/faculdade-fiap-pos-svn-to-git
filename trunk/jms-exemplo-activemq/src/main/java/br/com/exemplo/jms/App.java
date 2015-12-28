package br.com.exemplo.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsProducerTemplate");
		for (int i = 1; i < 5001; i++) {
			Thread.sleep(10000);
			enviaMsg(jmsTemplate, "Teste: "+i);
		}
		
	}

	private static void enviaMsg(JmsTemplate jmsTemplate, final String value) {
		jmsTemplate.send(new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage(value);
                
                
                return message;
			}
		});
	}
}
