package br.com.exemplo.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class JmsMessageListener implements MessageListener{

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage)message;
            try {
				String msg = tm.getText();
				System.out.println(msg);
			} catch (JMSException e) {
				e.printStackTrace();
			}
        }
		
	}

}
